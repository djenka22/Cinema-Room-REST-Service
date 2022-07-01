package cinema.web;



import cinema.domain.seat.entity.Cinema;
import cinema.domain.seat.service.SeatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatController {

    private final SeatServiceImpl seatService;

    @Autowired
    public SeatController(SeatServiceImpl seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/seats")
    public Cinema cinemaInfo() {
        return seatService.getCinemaInfo();
    }



}
