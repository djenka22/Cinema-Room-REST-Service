package cinema.infrastructure.exceptions;

import cinema.infrastructure.exceptions.cinema.CinemaException;
import cinema.infrastructure.exceptions.ticket.TicketException;
import cinema.infrastructure.exceptions.ticket.TicketResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(TicketException.class)
    public ResponseEntity<TicketResponse> handleTicketException (RuntimeException ex) {

        TicketResponse response = new TicketResponse(ex.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(CinemaException.class)
    public ResponseEntity<TicketResponse> handleCinemaException (RuntimeException ex) {

        TicketResponse response = new TicketResponse(ex.getMessage());
        return new ResponseEntity<>(response,HttpStatus.valueOf(401));

    }

}
