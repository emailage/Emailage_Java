package com.emailage.javawrapper.model;

public class EmailageApiRequestException extends Exception {
    public EmailageApiRequestException(String message, Exception e){super(message,e);}
}
