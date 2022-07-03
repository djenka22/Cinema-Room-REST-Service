package cinema.web;



import cinema.domain.cinema.entity.Cinema;
import cinema.domain.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {

    private final CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {

        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    public Cinema cinemaInfo() {

        return cinemaService.getCinemaInfo();
    }




}
