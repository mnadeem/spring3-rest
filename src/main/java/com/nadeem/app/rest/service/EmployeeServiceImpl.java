package com.nadeem.app.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nadeem.app.rest.common.exception.EmployeeNotFoundException;
import com.nadeem.app.rest.repository.entitiy.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

    @Override
    public List<Employee> findAll()
    {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1));
        employees.add(new Employee(2));
        employees.add(new Employee(3));
        return employees;
    }

    @Override
    public Employee findById(Long id) throws EmployeeNotFoundException
    {
        return new Employee(id);
    }

}
