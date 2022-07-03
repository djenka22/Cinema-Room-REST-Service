package cinema.domain.cinema.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CinemaStatistics {
    @JsonProperty("current_income")
    private Integer income;
    @JsonProperty("number_of_available_seats")
    private Integer availableSeats;
    @JsonProperty("number_of_purchased_tickets")
    private Integer purchasedTickets;

    public CinemaStatistics(Integer income, Integer availableSeats, Integer purchasedTickets) {
        this.income = income;
        this.availableSeats = availableSeats;
        this.purchasedTickets = purchasedTickets;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Integer getPurchasedTickets() {
        return purchasedTickets;
    }

    public void setPurchasedTickets(Integer purchasedTickets) {
        this.purchasedTickets = purchasedTickets;
    }
}
