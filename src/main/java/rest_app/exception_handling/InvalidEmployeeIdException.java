package rest_app.exception_handling;

public class InvalidEmployeeIdException extends RuntimeException {
    public InvalidEmployeeIdException(long id) {
        super(String.format("No employee with id %d exists in the database", id));
    }
}
