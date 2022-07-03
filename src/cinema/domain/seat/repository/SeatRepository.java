package cinema.domain.seat.repository;

import cinema.domain.cinema.repository.CinemaRepository;
import cinema.domain.seat.entity.Seat;
import cinema.infrastructure.exceptions.ticket.TicketException;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class SeatRepository {

    private static final Set<Seat> PURCHASED_TICKETS;

    static {
        PURCHASED_TICKETS = new HashSet<>();
    }

    public Seat purchaseTicket(Seat seat) {

        String message = "The number of a row or a column is out of bounds!";

        Seat toReturnSeat = findByRowAndColumn(seat);

        if (toReturnSeat == null) {
            throw new TicketException(message);
        }

        seatAvailability(toReturnSeat);

        PURCHASED_TICKETS.add(toReturnSeat);

        return toReturnSeat;
    }

    private void seatAvailability (Seat seat) {
        String message = "The ticket has been already purchased!";
        for (Seat s : PURCHASED_TICKETS) {
            if (s.equals(seat)) {
                throw new TicketException(message);
            }
        }
    }

    private Seat findByRowAndColumn (Seat seat) {
        for (Seat seat1 : CinemaRepository.getAllSeats()) {
            if (seat1.getRow().equals(seat.getRow())  && seat1.getColumn().equals(seat.getColumn())) {
                return seat1;
            }
        }
        return null;
    }

    public Set<Seat> getPurchasedTickets () {
        return PURCHASED_TICKETS;
    }
}
