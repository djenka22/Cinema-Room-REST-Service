package cinema.domain.cinema.repository;
import cinema.domain.cinema.entity.Cinema;
import cinema.domain.cinema.entity.CinemaStatistics;
import cinema.domain.seat.entity.Seat;
import cinema.domain.ticket.entity.Ticket;
import cinema.domain.ticket.repository.TicketRepository;
import cinema.infrastructure.exceptions.cinema.CinemaException;
import cinema.infrastructure.exceptions.ticket.TicketException;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class CinemaRepository {
    private static final Integer TOTAL_ROWS = 9;
    private static final Integer TOTAL_COLUMNS = 9;
    private static final List<Seat> SEATS;

    static {
        SEATS = autoFillSeats();
    }

    private static List<Seat> autoFillSeats() {

        List<Seat> seats = new ArrayList<>();
        for (int row = 1; row <= TOTAL_ROWS; row++) {
            for (int column = 1; column <= TOTAL_COLUMNS; column++) {
                seats.add(new Seat(row,column));
            }
        }
        return seats;
    }

    public static List<Seat> getAllSeats() {
        return SEATS;
    }

    public Integer getTotalRows () {
        return TOTAL_ROWS;
    }
    public Integer getTotalColumns () {
        return TOTAL_COLUMNS;
    }


    public CinemaStatistics getCinemaStatistics(String password) {

        if (password == null) {
            throw new CinemaException("The password is wrong!");
        }

        Integer income = getCurrentIncome();
        Integer numberOfAvailableSeats =
                SEATS.size() - TicketRepository.getPurchasedTickets().size();
        Integer numberOfPurchasedTickets =
                TicketRepository.getPurchasedTickets().size();

        return new CinemaStatistics(
                income, numberOfAvailableSeats, numberOfPurchasedTickets
        );
    }

    private int getCurrentIncome () {
        int income = 0;
        for (Ticket ticket : TicketRepository.getPurchasedTickets()) {
            income += ticket.getSeat().getPrice();
        }
        return income;
    }
}
