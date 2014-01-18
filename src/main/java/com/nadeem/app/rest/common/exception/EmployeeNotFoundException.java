package com.nadeem.app.rest.common.exception;

public class EmployeeNotFoundException extends RuntimeException
{

    private static final long serialVersionUID = 1L;
    
    public EmployeeNotFoundException(String message)
    {
        super(message);
    }
}
