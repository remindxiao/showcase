package com.domain.controller;

import com.domain.service.RedisService;
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
    private final RedisService redisService;

    @Autowired
    public UserController(UserService userService, RedisService redisService) {
        this.userService = userService;
        this.redisService = redisService;
    }
    @RequestMapping("/login")
    public String login(@RequestParam(value="name") String name, @RequestParam(value="password") String password){
        if(userService.login(name, password))
            return "SUCCESS! & loginTimes : "+redisService.get(name);
        else
            return "aoh... something was wrong,check check ...";
    }


    @RequestMapping(value = "/api/redis/put")
    public String redisPut(@RequestParam("name")String key, @RequestParam("logintimes")String value){
        return redisService.put(key, value);
    }

    @RequestMapping(value = "/api/redis/get")
    public String redisGet(){
        return redisService.get("lily");
    }

}
