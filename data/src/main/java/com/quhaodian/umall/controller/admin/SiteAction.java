package com.quhaodian.umall.controller.admin;

import com.ada.data.page.Pageable;
import com.quhaodian.umall.data.so.MemberSo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Scope("prototype")
@Controller
public class SiteAction {

    @RequestMapping("/admin/index")
    public String list(Pageable pageable, MemberSo so, ModelMap model) {
        return "/admin/home";
    }
}
