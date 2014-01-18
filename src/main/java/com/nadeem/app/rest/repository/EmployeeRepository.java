package com.nadeem.app.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nadeem.app.rest.repository.entitiy.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>
{

}
