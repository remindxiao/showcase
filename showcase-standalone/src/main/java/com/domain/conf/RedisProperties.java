package com.domain.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created Date : 16/7/20
 * Author : wujianwei
 */
@ConfigurationProperties(
        prefix = "spring.redis"
)
@Component
@Data
public class RedisProperties {
    private String host = "localhost";
    private int port = 6379;
}
