package com.cache.redisImpl.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo {

    void setEmployeeAsString(String id, String employee);

    String getEmployee(String id);

}
