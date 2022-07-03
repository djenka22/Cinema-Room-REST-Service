package cinema.web;

import cinema.domain.seat.entity.Seat;
import cinema.domain.seat.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;

@RestController
public class SeatController {
    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping("/purchase")
    public ResponseEntity<Seat> purchaseTicket (@RequestBody Seat seat) {
        return ResponseEntity.ok(seatService.purchaseTicket(seat));
    }

   @GetMapping("/purchased")
    public Set<Seat> getPurchasedTickets () {
        return seatService.getPurchasedTickets();
    }
}
