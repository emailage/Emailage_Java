package com.emailage.javawrapper.model.exception;

public class EmailageApiRequestException extends Exception {
    public EmailageApiRequestException(String message, Exception e){super(message,e);}
}
