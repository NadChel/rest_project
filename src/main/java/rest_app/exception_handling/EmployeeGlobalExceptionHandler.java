package rest_app.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<InvalidEmployeeIdMessage> handleInvalidEmployeeIdException(InvalidEmployeeIdException idException) {
        InvalidEmployeeIdMessage invalidEmployeeIdMessage = new InvalidEmployeeIdMessage();
        invalidEmployeeIdMessage.setInfo(idException.getMessage());
        return new ResponseEntity<>(invalidEmployeeIdMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<InvalidEmployeeIdMessage> handleInvalidEmployeeRequestException(Exception requestException) {
        InvalidEmployeeIdMessage invalidEmployeeIdMessage = new InvalidEmployeeIdMessage();
        invalidEmployeeIdMessage.setInfo(requestException.getMessage());
        return new ResponseEntity<>(invalidEmployeeIdMessage, HttpStatus.BAD_REQUEST);
    }
}
