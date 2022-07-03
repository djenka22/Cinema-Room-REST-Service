package cinema.domain.seat.service;


import cinema.domain.seat.entity.Seat;
import cinema.domain.seat.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public Seat purchaseTicket(Seat seat) {
        return seatRepository.purchaseTicket(seat);
    }

    @Override
    public Set<Seat> getPurchasedTickets() {
        return seatRepository.getPurchasedTickets();
    }
}
