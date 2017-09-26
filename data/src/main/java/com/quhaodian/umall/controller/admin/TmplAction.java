package com.quhaodian.umall.controller.admin;

import com.google.gson.Gson;
import com.quhaodian.umall.utils.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 模板管理
 *
 * @author 张浩伟
 * @version 1.01 2017年08月30日
 */
@Controller
@RequestMapping(value = "/admin")
public class TmplAction {

    @RequiresPermissions("tmpl")
    @RequestMapping("/tmpl/view_list")
    public String list(HttpServletRequest request, ModelMap model) {
        String path = request.getSession().getServletContext().getRealPath("WEB-INF/ftl");
        if (path != null) {
            List<FileUtils.FileTree> tree = FileUtils.getTree(path, "");

            model.addAttribute("tree", new Gson().toJson(tree));
        }
        return "/admin/tmpl/list";
    }

    @RequiresPermissions("tmpl")
    @RequestMapping(value = "/tmpl/view_file")
    @ResponseBody
    public String viewFile(String filename, HttpServletRequest request, ModelMap model) {
        String path = request.getSession().getServletContext().getRealPath("WEB-INF/ftl");
        if (path != null) {
            path = path + filename;
            return FileUtils.readFile(path);
        }
        return "";
    }

    @RequiresPermissions("tmpl")
    @RequestMapping(value = "/tmpl/view_save")
    @ResponseBody
    public String viewSave(String filename, String content, HttpServletRequest request, ModelMap model) {
        String path = request.getSession().getServletContext().getRealPath("WEB-INF/ftl");
        if (path != null) {
            path = path + filename;
            boolean saveFile = FileUtils.saveFile(path, content);
            if (saveFile){
                return "0";
            }
        }
        return "-1";
    }

}
