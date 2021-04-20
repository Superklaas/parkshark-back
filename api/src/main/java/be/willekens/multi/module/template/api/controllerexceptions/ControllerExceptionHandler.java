package be.willekens.multi.module.template.api.controllerexceptions;

import be.willekens.multi.module.template.infrastructure.exceptions.InvalidCategoryException;
import be.willekens.multi.module.template.infrastructure.exceptions.InvalidEmailException;
import be.willekens.multi.module.template.infrastructure.exceptions.InvalidPhoneNumberException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);



    @ExceptionHandler(InvalidEmailException.class)
    protected void invalidEmailHandler(InvalidEmailException ex, HttpServletResponse response) throws IOException {
        logger.error("Invalid email address submitted");
        response.sendError(BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(InvalidPhoneNumberException.class)
    protected void invalidPhoneNumberHandler(InvalidPhoneNumberException ex, HttpServletResponse response) throws IOException {
        logger.error("Attempt to create a contact person without a phone number");
        response.sendError(BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(InvalidCategoryException.class)
    protected void invalidCategoryHandler(InvalidCategoryException ex, HttpServletResponse response) throws IOException {
        logger.error("Attempt to create a parking lot with an invalid category");
        response.sendError(BAD_REQUEST.value(), ex.getMessage());
    }




}
