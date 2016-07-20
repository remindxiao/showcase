package com.domain.service;

import com.domain.conf.JedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * Created Date : 16/7/20
 * Author : wujianwei
 */

@Service
public class JedisService {

    private final JedisTemplate jedisTemplate;

    @Autowired
    public JedisService(JedisTemplate jedisTemplate) {
        this.jedisTemplate = jedisTemplate;
    }

    public String put(final String key, final String value){
        return jedisTemplate.execute(new JedisTemplate.JedisAction<String>() {
            @Override
            public String action(Jedis jedis) {
                return jedis.set(key, value);
            }
        });
    }


    public String get(final String key){
        return jedisTemplate.execute(new JedisTemplate.JedisAction<String>() {
            @Override
            public String action(Jedis jedis) {
                return jedis.get(key);
            }
        });
    }



}

