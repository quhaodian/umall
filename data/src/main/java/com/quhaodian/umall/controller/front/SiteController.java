package com.quhaodian.umall.controller.front;

import com.quhaodian.user.data.entity.UserAccount;
import com.quhaodian.user.data.service.UserAccountService;
import com.quhaodian.user.data.vo.UserAccountVo;
import com.quhaodian.user.enums.AccountType;
import com.quhaodian.web.controller.front.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SiteController extends BaseController {


    @Autowired
    UserAccountService userAccountService;

    @RequestMapping(value = "/index")
    public String index() {
        return getView("index");
    }

    @GetMapping(value = "/login")
    public String login() {
        return getView("login");
    }

    @PostMapping(value = "/login")
    public String loginWork(RedirectAttributes attributes) {
        attributes.addFlashAttribute("msg","密码错误");
        return  "redirect:login.htm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(String name, String username, String password,
                           HttpServletRequest request, HttpServletResponse response,
                           Model model) {

        UserAccount user = new UserAccount();
        user.setUsername(username);
        user.setPassword(password);
        user.setAccountType(AccountType.Account);
        UserAccountVo userx = userAccountService.reg(user);
        if (userx.getCode()==0) {
            model.addAttribute("msg", "注册成功");
            return "redirect:/login.htm";
        } else {
            model.addAttribute("msg", "注册失败");
            return getView("register");
        }

    }

    /**
     * 跳转登录页
     *
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return getView("register");
    }

    @GetMapping(value = "/signout")
    public String signout() {
        SecurityUtils.getSubject().logout();
        return  "redirect:index.htm";
    }
    @GetMapping(value = "/loginbypassword")
    public String loginByPassword(String username,String password,RedirectAttributes attributes) {


        AuthenticationToken token=new UsernamePasswordToken(username,password);
        try {
            SecurityUtils.getSubject().login(token);
            return  "redirect:index.htm";
        }catch (AuthenticationException e){

        }
        attributes.addFlashAttribute("msg","密码错误");
        return  "redirect:frontLogin.htm";
    }
    @GetMapping(value = "/frontLogin")
    public String frontLogin() {
        return getView("frontLogin");
    }

    @GetMapping(value = "/frontLogout")
    public String frontLogout() {
        SecurityUtils.getSubject().logout();
        return  "redirect:index.htm";
    }


    @GetMapping(value = "/frontRegister")
    public String frontRegister(String from, ModelMap map) {
        if ("c".equals(from) || "b".equals(from)) {
            map.addAttribute("type",from);
            return  getView("frontRegisterC");
        }
        return getView("frontRegister");
    }

    @GetMapping(value = "/privacy")
    public String privacy() {
        return  getView("privacy");
    }
}
