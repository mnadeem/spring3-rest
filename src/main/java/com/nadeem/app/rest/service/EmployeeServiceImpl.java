package com.nadeem.app.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nadeem.app.rest.common.exception.EmployeeNotFoundException;
import com.nadeem.app.rest.repository.EmployeeRepository;
import com.nadeem.app.rest.repository.entitiy.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    
    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<Employee> findAll()
    {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee.Builder("somuser1", "somuser1@domain.com").build());
        employees.add(new Employee.Builder("somuser2", "somuser2@domain.com").build());
        employees.add(new Employee.Builder("somuser3", "somuser3@domain.com").build());
        return employees;
        //return this.repository.findAll();
    }
    
    @Transactional(readOnly = true)
    @Override
    public Employee findById(Long id) throws EmployeeNotFoundException
    {
        //return new Employee.Builder("somuser1", "somuser1@domain.com").build();
        Employee found = repository.findOne(id);
        LOGGER.debug("Found to-do entry: {}", found);

        if (found == null) {
            throw new EmployeeNotFoundException("No to-entry found with id: " + id);
        }

        return found;
    }

}
