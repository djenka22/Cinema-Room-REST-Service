package cinema.domain.seat.service;



import cinema.domain.seat.entity.Cinema;
import cinema.domain.seat.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SeatServiceImpl implements SeatService {
    private final CinemaRepository cinemaRepository;

    @Autowired
    public SeatServiceImpl(CinemaRepository cinema) {
        this.cinemaRepository = cinema;
    }


    public Cinema getCinemaInfo() {
        return new Cinema(
                cinemaRepository.getTotalRows(), cinemaRepository.getTotalColumns(), cinemaRepository.getAllSeats()
        );
    }
}
