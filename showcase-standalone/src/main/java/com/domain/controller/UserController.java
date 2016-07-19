package com.domain.controller;

import com.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created Date : 16/7/19
 * Author : wujianwei
 */
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam(value="name") String name, @RequestParam(value="password") String password){
        if(userService.login(name, password))
            return "success";
        else
            return "no.such.user";
    }
}
