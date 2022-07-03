package cinema.domain.ticket.repository;

import cinema.domain.cinema.repository.CinemaRepository;
import cinema.domain.seat.entity.Seat;
import cinema.domain.ticket.entity.Ticket;
import cinema.domain.ticket.entity.TicketResponse;
import cinema.domain.ticket.entity.Token;
import cinema.infrastructure.exceptions.ticket.TicketException;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Repository
public class TicketRepository {
    private static final Set<Ticket> PURCHASED_TICKETS;

    static {
        PURCHASED_TICKETS = new HashSet<>();
    }

    public Ticket purchaseTicket(Seat seat) {
        Ticket ticket = new Ticket(seatForTicket(seat));
        ticketAvailability(ticket);
        PURCHASED_TICKETS.add(ticket);
        return ticket;
    }

    private Seat seatForTicket(Seat seat) {
        for (Seat seat1 : CinemaRepository.getAllSeats()) {
            if (seat1.getRow().equals(seat.getRow()) && seat1.getColumn().equals(seat.getColumn())) {
                return seat1;
            }
        }
        throw new TicketException("The number of a row or a column is out of bounds!");
    }

    private void ticketAvailability(Ticket ticket) {
        for (Ticket ticket1 : PURCHASED_TICKETS) {
            if (ticket1.getSeat().equals(ticket.getSeat())) {
                throw new TicketException("The ticket has been already purchased!");
            }
        }
    }

    public Set<Ticket> getPurchasedTickets() {
        return PURCHASED_TICKETS;
    }

    public TicketResponse returnTicket(Token token) {
        return new TicketResponse(
                findByToken(token).getSeat()
        );
    }

    private Ticket findByToken(Token token) {

            for (Ticket ticket : PURCHASED_TICKETS) {
                if (ticket.getToken().equals(token.getToken())) {
                    return ticket;
                }
            }

        throw new TicketException("Wrong token!");

    }
}
