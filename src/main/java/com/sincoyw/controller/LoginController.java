package com.sincoyw.controller;

import com.sincoyw.domain.UserInfo;
import com.sincoyw.model.LoginInfo;
import com.sincoyw.service.UserService;
import com.sincoyw.status.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Sincoyw on 2016/6/30.
 */
@Controller
@ComponentScan("com.sincoyw")
public class LoginController {

    @Autowired
    private UserService userService;

    //
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginInfo", new LoginInfo());
        return "login";
    }

    //
    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute LoginInfo loginInfo) {
        int loginResult = userService.loginWithUserIdPassword(loginInfo.getEmail(), loginInfo.getPassword());
        if (LoginResult.Success == loginResult) {
            return "loginSuccess";
        } else {
            return "loginFail";
        }
    }

}
