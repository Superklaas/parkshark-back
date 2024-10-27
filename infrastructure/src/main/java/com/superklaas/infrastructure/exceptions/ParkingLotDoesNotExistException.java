package com.superklaas.infrastructure.exceptions;

public class ParkingLotDoesNotExistException extends RuntimeException{
    public ParkingLotDoesNotExistException(String message) {
        super(message);
    }
}
