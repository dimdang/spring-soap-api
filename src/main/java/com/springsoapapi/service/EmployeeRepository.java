package com.springsoapapi.service;

import com.springsoapapi.employee.Employee;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dang Dim
 * Date     : 3/18/2019, 11:26 AM
 * Email    : d.dim@gl-f.com
 */

@Component
public class EmployeeRepository {

    private static final Map<Long, Employee> emps = new HashMap<>();
    List<Employee> employees = new ArrayList<>();

    @PostConstruct
    public void init() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstname("bucky");
        employee.setLastname("born");
        employee.setEmail("bucky@gmail.com");
        employee.setJobtitle("Software Engineer");

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setFirstname("Red");
        employee2.setLastname("Coat");
        employee2.setEmail("redcoat@gmail.com");
        employee2.setJobtitle("IOS Engineer");

        emps.put(employee.getId(), employee);
        emps.put(employee2.getId(), employee);
        employees.add(employee);
        employees.add(employee2);
    }

    public List<Employee> getEmployee(){
        return employees;
    }

    public Employee findEmployee(Long id){
        return emps.get(id);
    }


}
