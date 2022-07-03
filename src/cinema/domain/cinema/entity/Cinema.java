package cinema.domain.cinema.entity;

import cinema.domain.seat.entity.Seat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
public class Cinema {
    @JsonProperty("total_rows")
    private Integer rows;
    @JsonProperty("total_columns")
    private Integer columns;
    @JsonProperty("available_seats")
    private List<Seat> availableSeats;

    public Cinema(Integer rows, Integer columns, List<Seat> availableSeats) {
        this.rows = rows;
        this.columns = columns;
        this.availableSeats = availableSeats;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getColumns() {
        return columns;
    }

    public void setColumns(Integer columns) {
        this.columns = columns;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }


}
