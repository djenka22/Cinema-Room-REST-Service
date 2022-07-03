package cinema.infrastructure.exceptions.cinema;

public class CinemaException extends RuntimeException{
    String message;

    public CinemaException(String message) {
        this.message = message;
    }

    public CinemaException() {
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
