package cinema.domain.cinema.service;

import cinema.domain.cinema.entity.Cinema;
import cinema.domain.cinema.entity.CinemaStatistics;
import cinema.domain.seat.entity.Seat;


public interface CinemaService {
    Cinema getCinemaInfo();
    CinemaStatistics getCinemaStatistics(String password);
}
