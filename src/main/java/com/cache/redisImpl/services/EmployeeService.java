package com.cache.redisImpl.services;

public interface EmployeeService  {

    //String
    void setEmployeeAsString(String id, String employee);

    String getEmployee(String id);
}
