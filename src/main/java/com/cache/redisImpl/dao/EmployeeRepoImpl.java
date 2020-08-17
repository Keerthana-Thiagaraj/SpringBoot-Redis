package com.cache.redisImpl.dao;

import com.cache.redisImpl.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {

    public static final String REDIS_LIST_KEY = "EmployeeList";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate; //Access Redis database, by using bean defined in config class

    @Autowired
    @Qualifier("listOperations")
    private ListOperations<String, Employee> listOperations;

    //String operations

    @Override
    public void setEmployeeAsString(String id, String employee) {
        redisTemplate.opsForValue().set(id, employee);
        redisTemplate.expire(id, 10, TimeUnit.SECONDS);
    }

    @Override
    public String getEmployee(String id) {
        return (String) redisTemplate.opsForValue().get(id);
    }

    //List operations
    @Override
    public void addEmployeeList(Employee employee) {
//        redisTemplate.opsForList().leftPush(REDIS_LIST_KEY, employee);
        listOperations.leftPush(REDIS_LIST_KEY, employee); //opsforlist is defined as bean in config
    }

    @Override
    public List<Employee> getEmployeeList() {
        return listOperations.range(REDIS_LIST_KEY, 0, -1);
    }
}
