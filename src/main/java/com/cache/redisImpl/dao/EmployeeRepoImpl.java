package com.cache.redisImpl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class EmployeeRepoImpl implements EmployeeRepo {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate; //Access Redis database, by using bean defined in config class

    @Override
    public void setEmployeeAsString(String id, String employee) {
        redisTemplate.opsForValue().set(id, employee);
        redisTemplate.expire(id, 10, TimeUnit.SECONDS);
    }

    @Override
    public String getEmployee(String id) {
        return (String) redisTemplate.opsForValue().get(id);
    }
}
