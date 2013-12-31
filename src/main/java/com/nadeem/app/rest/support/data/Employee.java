package com.nadeem.app.rest.support.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employee")
public class Employee
{
    
    private long id;
    private String name;
    private String email;
    
    public Employee()
    {
        // TODO Auto-generated constructor stub
    }

    public Employee(long parseLong)
    {
        this.id= parseLong;
    }
    public long getId()
    {
        return id;
    }
    public void setId(long id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    
}
