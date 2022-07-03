package cinema.domain.seat.service;

import cinema.domain.seat.entity.Seat;

import java.util.Set;

public interface SeatService {
    Seat purchaseTicket(Seat seat);

    Set<Seat> getPurchasedTickets();
}
