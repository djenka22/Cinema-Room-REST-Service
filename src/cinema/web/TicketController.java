package cinema.web;

import cinema.domain.seat.entity.Seat;
import cinema.domain.ticket.entity.Ticket;
import cinema.domain.ticket.entity.TicketResponse;
import cinema.domain.ticket.entity.Token;
import cinema.domain.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;

@RestController
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/purchase")
    public ResponseEntity<Ticket> purchaseTicket (@RequestBody Seat seat) {
        return ResponseEntity.ok(ticketService.purchaseTicket(seat));
    }
    @GetMapping("/purchased")
    public Set<Ticket> getPurchasedTickets () {
        return ticketService.getPurchasedTickets();
    }

    @PostMapping("/return")
    public ResponseEntity<TicketResponse> returnTicket (@RequestBody Token token) {
        return ResponseEntity.ok(ticketService.returnTicket(token));
    }
}
