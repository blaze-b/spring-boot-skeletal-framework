package com.org.projectname.integration.errorhandler;

import com.org.projectname.integration.errorhandler.dto.ErrorResponse;
import com.org.projectname.integration.errorhandler.exception.DuplicateValueException;
import com.org.projectname.integration.errorhandler.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({DuplicateValueException.class})
    @ResponseStatus(CONFLICT)
    public ResponseEntity<ErrorResponse> handleConflictException(Exception ex) {
        log.error("Error: User Already Found", ex);
        return new ResponseEntity(new ErrorResponse(ex.getMessage(), CONFLICT.value()), CONFLICT);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleNotFoundException(Exception ex) {
        log.error("Error: User Already Found", ex);
        return new ResponseEntity(new ErrorResponse(ex.getMessage(), NOT_FOUND.value()), NOT_FOUND);
    }
}
