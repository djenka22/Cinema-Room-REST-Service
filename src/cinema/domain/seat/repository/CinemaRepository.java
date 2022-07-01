package cinema.domain.seat.repository;


import cinema.domain.seat.entity.Seat;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository
public class CinemaRepository {


    private static final Integer TOTAL_ROWS = 9;
    private static final Integer TOTAL_COLUMNS = 9;
    private static final List<Seat> SEATS;

    static {
        SEATS = autoFillSeats();
    }

    public static List<Seat> autoFillSeats() {

        List<Seat> seats = new ArrayList<>();
        for (int row = 1; row <= TOTAL_ROWS; row++) {
            for (int column = 1; column <= TOTAL_COLUMNS; column++) {
                seats.add(new Seat(row,column));
            }
        }
        return seats;
    }

    public List<Seat> getAllSeats() {
        return SEATS;
    }
    public Integer getTotalRows() {
        return TOTAL_ROWS;
    }
    public Integer getTotalColumns() {
        return TOTAL_COLUMNS;
    }

}
