package cinema.domain.ticket.service;

import cinema.domain.seat.entity.Seat;
import cinema.domain.ticket.entity.Ticket;
import cinema.domain.ticket.entity.TicketResponse;
import cinema.domain.ticket.entity.Token;
import cinema.domain.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService{
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket purchaseTicket (Seat seat) {
        return ticketRepository.purchaseTicket(seat);
    }

    @Override
    public Set<Ticket> getPurchasedTickets() {

        return ticketRepository.getPurchasedTickets();
    }

    @Override
    public TicketResponse returnTicket(Token token) {
        return ticketRepository.returnTicket(token);
    }
}
