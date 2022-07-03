package cinema.domain.ticket.entity;

import cinema.domain.seat.entity.Seat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketResponse {
    @JsonProperty("returned_ticket")
    Seat seat;

    public TicketResponse() {
    }

    public TicketResponse(Seat seat) {
        this.seat = seat;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
