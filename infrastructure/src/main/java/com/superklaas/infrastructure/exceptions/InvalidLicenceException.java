package com.superklaas.infrastructure.exceptions;

public class InvalidLicenceException extends RuntimeException{
    public InvalidLicenceException(String message) {
        super(message);
    }
}
