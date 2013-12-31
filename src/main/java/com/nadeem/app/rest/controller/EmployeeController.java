package com.nadeem.app.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nadeem.app.rest.support.data.Employee;
import com.nadeem.app.rest.support.data.EmployeeList;

@Controller
public class EmployeeController {
    
    @RequestMapping(method=RequestMethod.GET, value="/emp/{id}", headers="Accept=application/json,application/xml",  produces={"application/json","application/xml"})
    public @ResponseBody Employee getEmp(@PathVariable String id) {
        Employee e = new Employee(Long.parseLong(id));
        return e;
    }

    @RequestMapping(method=RequestMethod.GET, value="/emps")
    public @ResponseBody EmployeeList getAllEmp() {

        EmployeeList list = new EmployeeList(newEmployees());
        return list;
    }

    private List<Employee> newEmployees()
    {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1));
        employees.add(new Employee(2));
        return employees;
    }
}