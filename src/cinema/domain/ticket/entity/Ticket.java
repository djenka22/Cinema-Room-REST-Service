package cinema.domain.ticket.entity;

import cinema.domain.seat.entity.Seat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Ticket {
    private UUID token;
    @JsonProperty("ticket")
    private Seat seat;

    public Ticket() {
    }

    public Ticket(Seat seat) {
        this.token = UUID.randomUUID();
        this.seat= seat;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat ticket) {
        this.seat = ticket;
    }
}
