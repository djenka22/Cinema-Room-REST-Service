package cinema.domain.cinema.service;
import cinema.domain.cinema.entity.Cinema;
import cinema.domain.cinema.entity.CinemaStatistics;
import cinema.domain.cinema.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CinemaServiceImpl implements CinemaService {
    private final CinemaRepository cinemaRepository;

    @Autowired
    public CinemaServiceImpl(CinemaRepository cinema) {
        this.cinemaRepository = cinema;
    }


    @Override
    public Cinema getCinemaInfo() {
        return new Cinema(
                cinemaRepository.getTotalRows(),
                cinemaRepository.getTotalColumns(),
                cinemaRepository.getAllSeats()
        );
    }

    @Override
    public CinemaStatistics getCinemaStatistics(String password) {
        return cinemaRepository.getCinemaStatistics(password);
    }
}
