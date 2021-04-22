package be.willekens.multi.module.template.infrastructure.exceptions;

public class ParkingLotDoesNotExistException extends RuntimeException{
    public ParkingLotDoesNotExistException(String message) {
        super(message);
    }
}
