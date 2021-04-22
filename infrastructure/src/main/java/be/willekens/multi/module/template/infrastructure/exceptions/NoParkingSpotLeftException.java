package be.willekens.multi.module.template.infrastructure.exceptions;

public class NoParkingSpotLeftException extends RuntimeException{
    public NoParkingSpotLeftException(String message) {
        super(message);
    }
}
