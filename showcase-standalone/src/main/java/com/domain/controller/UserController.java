package com.domain.controller;

import com.domain.service.JedisService;
import com.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created Date : 16/7/19
 * Author : wujianwei
 */
@RestController
public class UserController {
    private final UserService userService;
    private final JedisService jedisService;

    @Autowired
    public UserController(UserService userService, JedisService jedisService) {
        this.userService = userService;
        this.jedisService = jedisService;
    }
    @RequestMapping("/login")
    public String login(@RequestParam(value="name") String name, @RequestParam(value="password") String password){
        if(userService.login(name, password))
            return "success";
        else
            return "no.such.user";
    }


    @RequestMapping(value = "/api/redis/put")
    public String redisPut(@RequestParam("key")String key, @RequestParam("value")String value){
        return jedisService.put(key, value);
    }

    @RequestMapping(value = "/api/redis/get")
    public String redisGet(){
        return jedisService.get("wujianwei");
    }

}
