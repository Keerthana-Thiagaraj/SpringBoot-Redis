package com.cache.redisImpl.model;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class Employee implements Serializable {

    private int id;

    private String empName;

    private String empGender;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() &&
                getEmpName().equals(employee.getEmpName()) &&
                getEmpGender().equals(employee.getEmpGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmpName(), getEmpGender());
    }
}
