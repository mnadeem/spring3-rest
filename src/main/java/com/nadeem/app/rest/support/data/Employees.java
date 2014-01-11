package com.nadeem.app.rest.support.data;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employees")
public class Employees {
    private int count;
    private List<Employee> employees;

    public Employees() {}
    
    public Employees(List<Employee> employees) {
        this.employees = employees;
        this.count = employees.size();
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    
    @XmlElement(name="employee")
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    
}