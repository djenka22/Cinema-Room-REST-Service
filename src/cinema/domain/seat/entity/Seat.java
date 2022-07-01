package cinema.domain.seat.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class Seat {

    private Integer row;
    private Integer column;

    public Seat(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }
}