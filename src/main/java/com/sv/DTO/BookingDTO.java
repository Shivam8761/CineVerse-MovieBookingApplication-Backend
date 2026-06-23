package com.sv.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BookingDTO {

    private Integer numberOfSeats;
    private LocalDateTime bookingTime;
    private Double price;
    private Long showId;
    private Long userId;

    private List<String> seatNumbers;

}
