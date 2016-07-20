package com.domain.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * Created Date : 16/7/20
 * Author : wujianwei
 */

@Configuration
@ComponentScan
public class RedisConfig {

    @Autowired
    private RedisProperties redisProperties;


    @Bean
    public JedisPool jedisPool(){
        return new JedisPool(redisProperties.getHost(), redisProperties.getPort());
    }
}
