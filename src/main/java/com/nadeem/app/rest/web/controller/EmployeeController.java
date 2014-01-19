package com.nadeem.app.rest.web.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codahale.metrics.annotation.Timed;
import com.nadeem.app.rest.common.EntityConverter;
import com.nadeem.app.rest.repository.entitiy.Employee;
import com.nadeem.app.rest.service.EmployeeService;
import com.nadeem.app.rest.web.support.data.EmployeeData;
import com.nadeem.app.rest.web.support.data.Employees;

@Controller
@RequestMapping("/service")
public class EmployeeController {

    private EmployeeService employeeService;
    private Mapper dozerMapper;

    @Timed
    @RolesAllowed("ROLE_ADMIN")
    @RequestMapping(method=RequestMethod.GET,
        value = "/emp/{id}",
        headers = "Accept=application/json,application/xml",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public EmployeeData getEmp(@PathVariable("id") Long id) {
        Employee employee = this.employeeService.findById(id);
        return this.dozerMapper.map(employee, EmployeeData.class);
    }

    @Timed
    @RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(method = RequestMethod.GET,
                value="/emps")
    @ResponseBody
    public Employees getAllEmp() {
        
        List<Employee> employees = this.employeeService.findAll();

        return new Employees(EntityConverter.convert(this.dozerMapper, employees, EmployeeData.class));
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }
    @Autowired
    public void setDozerBeanMapper(Mapper dozerBeanMapper)
    {
        this.dozerMapper = dozerBeanMapper;
    }
    
}
