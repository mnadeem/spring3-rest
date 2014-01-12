package com.nadeem.app.rest.web.support.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="errors")
public class ErrorMessages {
 
    private String code;
    private List<String> errors;
 
    public ErrorMessages() {

    }

    public ErrorMessages(String error) {
        this(Collections.singletonList(error));
    }
    
    public ErrorMessages(final int newCode, String error) {
        this(newCode, Collections.singletonList(error));
    }

    public ErrorMessages(final List<String> errors) {
        this.errors = errors;
        this.code = "Un known";
    }
    
    public ErrorMessages(final int newCode, final List<String> errors) {
        this.errors = errors;
        this.code = String.valueOf(newCode);
    }

    public ErrorMessages(final String newCode, final List<String> errors) {
        this.errors = errors;
        this.code = newCode;
    }

    public ErrorMessages(String ... errors) {
        this(Arrays.asList(errors));
    }
 
    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }
}
