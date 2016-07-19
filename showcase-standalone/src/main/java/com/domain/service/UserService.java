package com.domain.service;

import com.domain.dao.UserDao;
import com.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created Date : 16/7/19
 * Author : wujianwei
 */
@Service
public class UserService {

    private final UserDao userDao;
    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean login(String name,String password){
        if(userDao.login(name,password).size()==1)
            return true;
        else
            return false;

    }
}
