package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 @author：ZhouYao
 @create：2022-01-03 15:41
 */

@Controller
public class IndexController {

    /**
     * 来登陆页
     * @return
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {

        if (!StringUtils.isEmpty(user.getUserName()) && !StringUtils.isEmpty(user.getPassword())) {
            // 把登录成功的用户保存起来
            session.setAttribute("loginUser", user);
            // 登录成功，重定向的main.html
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            // 回到登录页面
            return "login";
        }
    }

    /**
     * 去main页面
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {

        // 是否登录。 拦截器 过滤器
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return "main";
        } else {
            // 回到登录页面
            model.addAttribute("msg", "请重新登录");
            return "login";
        }
    }


}
