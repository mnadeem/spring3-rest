package com.nadeem.app.rest.service;

import java.util.List;

import com.nadeem.app.rest.common.exception.EmployeeNotFoundException;
import com.nadeem.app.rest.repository.entitiy.Employee;

public interface EmployeeService
{
    
    /**
     * Returns a list of to-do entries.
     * @return
     */
    public List<Employee> findAll();

    /**
     * Finds a to-do entry.
     * @param id    The id of the wanted to-do entry.
     * @return  The found to-entry.
     * @throws EmployeeNotFoundException    if no employee entry is found with the given id.
     */
    public Employee findById(Long id) throws EmployeeNotFoundException;

}
