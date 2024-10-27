package com.superklaas.api.controllerexceptions;

import com.superklaas.infrastructure.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(InvalidLicenceException.class)
    protected void invalidLicencePlateHandler(InvalidLicenceException ex, HttpServletResponse response) throws IOException {
        logger.error("Invalid licence plate submitted");
        response.sendError(BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(MemberDoesNotExistException.class)
    protected void memberDoesNotExistHandler(MemberDoesNotExistException ex, HttpServletResponse response) throws IOException {
        logger.error("This member does not exist");
        response.sendError(BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(NoParkingSpotLeftException.class)
    protected void noParkingSpotsLeftHandler(NoParkingSpotLeftException ex, HttpServletResponse response) throws IOException {
        logger.error("No parking spots left");
        response.sendError(BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(ParkingLotDoesNotExistException.class)
    protected void parkingLotDoesNotExistHandler(ParkingLotDoesNotExistException ex, HttpServletResponse response) throws IOException {
        logger.error("This parking lot does not exist");
        response.sendError(BAD_REQUEST.value(), ex.getMessage());
    }

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
