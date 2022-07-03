package cinema.infrastructure.exceptions.ticket;


public class TicketException extends RuntimeException {

    private String message;

    public TicketException() {
    }

    public TicketException(String error) {
        this.message= error;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
