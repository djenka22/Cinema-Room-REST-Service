package cinema.web;



import cinema.domain.cinema.entity.Cinema;
import cinema.domain.cinema.entity.CinemaStatistics;
import cinema.domain.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {

    private final CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {

        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    public ResponseEntity<Cinema> getCinemaInfo() {

        return ResponseEntity.ok(cinemaService.getCinemaInfo());
    }

    @PostMapping("/stats")
    public ResponseEntity<CinemaStatistics> getCinemaStatistics (@RequestParam(required = false) String password) {
        return ResponseEntity.ok(cinemaService.getCinemaStatistics(password));
    }







}
