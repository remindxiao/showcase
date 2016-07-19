package com.domain.dao;

import com.domain.model.User;
import com.google.common.collect.ImmutableMap;
import io.terminus.common.mysql.dao.MyBatisDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created Date : 16/7/19
 * Author : wujianwei
 *
 */
@Repository
public class UserDao extends MyBatisDao<User>{

    public List<User> login(String name, String password) {
        return this.getSqlSession().selectList(sqlId("findUser"), ImmutableMap.of("name",name,"password",password));
    }
}
