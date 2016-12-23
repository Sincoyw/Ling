package com.sincoyw.controller;

import com.sincoyw.domain.UserInfo;
import com.sincoyw.model.SignUpInfo;
import com.sincoyw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

/**
 * Created by heaven on 16-12-22.
 */
@Controller
@ComponentScan("com.sincoyw")
public class SignUpController {
    //
    @Autowired
    private UserService userService;

    //
    @GetMapping("/signUp")
    public String signUp(Model model) {
        model.addAttribute("signUpInfo", new SignUpInfo());
        return "signUp";
    }

    //
    @PostMapping("/signUp")
    public String signUpFormSubmit(@ModelAttribute SignUpInfo signUpInfo) {
        UserInfo userInfo = userService.findUserByEmail(signUpInfo.getEmail());
        if (null == userInfo) {
            userService.createNewAccount(
                    signUpInfo.getEmail(),
                    signUpInfo.getPassword(),
                    0,
                    signUpInfo.getCellphone(),
                    new Date(),
                    signUpInfo.getHomeSite(),
                    signUpInfo.getEmail()
            );
            return "loginSuccess";
        } else {
            return "emailAlreadyExist";
        }
    }
}
