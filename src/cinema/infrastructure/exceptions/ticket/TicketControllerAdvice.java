package cinema.infrastructure.exceptions.ticket;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TicketControllerAdvice {

    @ExceptionHandler(TicketException.class)
    public ResponseEntity<TicketResponse> handleTicketException (RuntimeException ex) {

        TicketResponse response = new TicketResponse(ex.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

    }
}
