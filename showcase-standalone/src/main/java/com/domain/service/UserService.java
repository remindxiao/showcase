package com.domain.service;

import com.domain.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created Date : 16/7/19
 * Author : wujianwei
 */
@Service
public class UserService {

    private final UserDao userDao;
    private final RedisService redisService;
    private Integer loginTimes=0;
    @Autowired
    public UserService(UserDao userDao, RedisService redisService) {
        this.userDao = userDao;
        this.redisService = redisService;
    }

    public boolean login(String name,String password){
        if(userDao.login(name,password).size()==1) {
            if(redisService.get(name)!=null)
                loginTimes = Integer.parseInt(redisService.get(name))+1;
//            loginTimes=3;
            else
                loginTimes=1;
            redisService.put(name,loginTimes+"");
            return true;
        }
        else
            return false;

    }
}
