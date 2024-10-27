package com.superklaas.infrastructure.exceptions;

public class MemberDoesNotExistException extends RuntimeException{
    public MemberDoesNotExistException(String message) {
        super(message);
    }
}
