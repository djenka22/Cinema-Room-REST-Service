package cinema.domain.ticket.service;

import cinema.domain.seat.entity.Seat;
import cinema.domain.ticket.entity.Ticket;
import cinema.domain.ticket.entity.TicketResponse;
import cinema.domain.ticket.entity.Token;

import java.util.Set;
import java.util.UUID;

public interface TicketService {
    Ticket purchaseTicket (Seat seat);

    Set<Ticket> getPurchasedTickets();

    TicketResponse returnTicket (Token token);


}
