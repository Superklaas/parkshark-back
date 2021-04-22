package be.willekens.multi.module.template.infrastructure.exceptions;

public class MemberDoesNotExistException extends RuntimeException{
    public MemberDoesNotExistException(String message) {
        super(message);
    }
}
