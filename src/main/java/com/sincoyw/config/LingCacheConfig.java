package com.sincoyw.config;

import com.sincoyw.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by heaven on 16-12-29.
 * Config the cache strategy for the project, first Redis.
 */
@Configuration
@ComponentScan("com.sincoyw")
public class LingCacheConfig {
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setUsePool(true);
//        jedisConnectionFactory.setPort(6379);
//        jedisConnectionFactory.setHostName("localhost");
//        jedisConnectionFactory.setPassword("ling_man");
//        jedisConnectionFactory.setTimeout();

        return jedisConnectionFactory;
    }

    @Bean
    @Autowired
    public RedisTemplate<String, UserInfo> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String, UserInfo> redisTemplate = new RedisTemplate<String, UserInfo>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        return redisTemplate;
    }
}
