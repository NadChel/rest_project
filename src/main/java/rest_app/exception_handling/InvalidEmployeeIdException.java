package rest_app.exception_handling;

public class InvalidEmployeeIdException extends RuntimeException {
    public InvalidEmployeeIdException(long id) {
        super(String.format("An id cannot be %d", id));
    }
}
