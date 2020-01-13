package com.pfy.blog.controller.admin;


import com.pfy.blog.entity.User;
import com.pfy.blog.service.impl.UserServiceImpl;
import com.pfy.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/login")
    public String toLogin(){
        return "admin/login";
    }

    @RequestMapping("/blogs")
    public String toBlog(@RequestParam String username,
                         @RequestParam String password,
                         HttpSession session,
                         HttpServletRequest request,
                         RedirectAttributes attributes) {
        User user = userServiceImpl.selectUser(username);
        if (user != null) {
            if (user.getPassword().equals(MD5Utils.code(password))) {
                user.setPassword(null);
                request.getSession().setAttribute("user", user);
                return "redirect:/admin/blog";
            } else {
                attributes.addFlashAttribute("message", "用户名和密码错误");
                return "redirect:/admin/login";
            }
        } else {
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/admin/login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin/login";
    }
}
