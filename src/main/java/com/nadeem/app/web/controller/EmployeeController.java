package com.nadeem.app.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nadeem.app.web.support.data.EmployeeData;
import com.nadeem.app.web.support.data.Employees;

@Controller
public class EmployeeController {
    
    @RolesAllowed("Admin")
    @RequestMapping(method=RequestMethod.GET,
        value = "/emp/{id}",
        headers = "Accept=application/json,application/xml",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public EmployeeData getEmp(@PathVariable String id) {
        EmployeeData e = new EmployeeData(Long.parseLong(id));
        return e;
    }
 
    @RolesAllowed({"Admin", "User"})
    @RequestMapping(method = RequestMethod.GET,
                value="/emps")
    @ResponseBody
    public Employees getAllEmp() {

        Employees list = new Employees(newEmployees());
        return list;
    }

    private List<EmployeeData> newEmployees()
    {
        List<EmployeeData> employees = new ArrayList<EmployeeData>();
        employees.add(new EmployeeData(1));
        employees.add(new EmployeeData(2));
        return employees;
    }
}