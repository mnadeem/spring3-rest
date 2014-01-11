package com.nadeem.app.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nadeem.app.common.exception.UnauthorizedError;
import com.nadeem.app.web.support.data.ErrorMessages;

@ControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {
 
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
        List<String> errors = new ArrayList<String>(fieldErrors.size() + globalErrors.size());
        String error;
        for (FieldError fieldError : fieldErrors) {
            error = fieldError.getField() + ", " + fieldError.getDefaultMessage();
            errors.add(error);
        }
        for (ObjectError objectError : globalErrors) {
            error = objectError.getObjectName() + ", " + objectError.getDefaultMessage();
            errors.add(error);
        }
        ErrorMessages errorMessage = new ErrorMessages(status.value(), errors);
        return new ResponseEntity<Object>(errorMessage, headers, status);
    }
 
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String unsupported = "Unsupported content type: " + ex.getContentType();
        String supported = "Supported content types: " + MediaType.toString(ex.getSupportedMediaTypes());
        ErrorMessages errorMessage = new ErrorMessages(unsupported, supported);
        return new ResponseEntity<Object>(errorMessage, headers, status);
    }
 
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Throwable mostSpecificCause = ex.getMostSpecificCause();
        ErrorMessages errorMessage;
        if (mostSpecificCause != null) {
            String exceptionName = mostSpecificCause.getClass().getName();
            String message = mostSpecificCause.getMessage();
            errorMessage = new ErrorMessages(exceptionName, message);
        } else {
            errorMessage = new ErrorMessages(ex.getMessage());
        }
        return new ResponseEntity<Object>(errorMessage, headers, status);
    }
    
    // Convert a predefined exception to an HTTP Status code
    //@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Un Authorized Access")
    @ExceptionHandler(UnauthorizedError.class)
    @ResponseBody
    public ErrorMessages handleException(UnauthorizedError ex) {
        ErrorMessages errorMessage = new ErrorMessages("Un Authorized Access");
        return errorMessage;
    }
}
