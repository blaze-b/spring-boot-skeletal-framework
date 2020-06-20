package com.org.projectname.integration.errorhandler;

import com.org.projectname.integration.errorhandler.dto.ErrorResponse;
import com.org.projectname.integration.errorhandler.exception.DuplicateValueException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CONFLICT;

@Slf4j
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({DuplicateValueException.class})
    @ResponseStatus(CONFLICT)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(Exception ex) {
        log.error("Error: User Already Found", ex);
        return new ResponseEntity(new ErrorResponse(ex.getMessage(), CONFLICT.value()), CONFLICT);
    }
}
