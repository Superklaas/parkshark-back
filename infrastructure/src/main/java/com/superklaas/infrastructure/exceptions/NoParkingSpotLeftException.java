package com.superklaas.infrastructure.exceptions;

public class NoParkingSpotLeftException extends RuntimeException{
    public NoParkingSpotLeftException(String message) {
        super(message);
    }
}
