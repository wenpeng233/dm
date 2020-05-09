package base.dao.mapper;

import base.entity.Seat;

import java.util.List;

public interface SeatMapper {
    Seat getSeat(String seatId);

    List<Seat> getSeats();

    boolean setSeats(List<Seat> seats);

    boolean seatSeatSchedule(String seatId, String orderId, String userId);
}
