package com.sincoyw.controller;

import com.sincoyw.service.UserService;
import com.sincoyw.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Sincoyw on 2016/6/30.
 */
@Controller
@ComponentScan("com.sincoyw")
public class GreetingController {

    @Autowired
    private UserService userService;

    //
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greeting() {
        // TODO:do something
        return "greeting";
    }
}
