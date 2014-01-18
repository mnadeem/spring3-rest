package com.nadeem.app.rest.web.support.data;

import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;

@XmlRootElement(name="employee")
public class EmployeeData
{

    private long id;
    private String name;
    private String email;
    private DateTime creationTime;
    private DateTime modificationTime;
    
    public EmployeeData()
    {

    }

    public EmployeeData(long parseLong)
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

    public DateTime getCreationTime()
    {
        return creationTime;
    }

    public void setCreationTime(DateTime creationTime)
    {
        this.creationTime = creationTime;
    }

    public DateTime getModificationTime()
    {
        return modificationTime;
    }

    public void setModificationTime(DateTime modificationTime)
    {
        this.modificationTime = modificationTime;
    }
}
