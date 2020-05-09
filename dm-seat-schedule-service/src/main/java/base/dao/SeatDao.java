package base.dao;

import base.dao.mapper.SeatMapper;
import base.entity.Seat;
import base.entity.SeatSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SeatDao implements SeatMapper {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Seat getSeat(String seatId) {
        String sql = "select * from t_seat_info where seat_id = ？";
        List<Seat> seats = jdbcTemplate.query(sql, new Object[]{seatId}, new SeatRowMapper());
        if (! seats.isEmpty()) {
            return seats.get(0);
        }
        return new Seat();
    }

    @Override
    public List<Seat> getSeats() {
        String sql = "select * from t_seat_info";
        List<Seat> seats = jdbcTemplate.queryForList(sql, Seat.class);
        return seats;
    }

    @Override
    public boolean setSeats(List<Seat> seats) {
        return false;
    }

    @Override
    public boolean seatSeatSchedule(final String seatId, final String orderId, final String userId) {
        final String sql = "insert into t_seat_schedule (seat_id, order_id, user_id) values (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        try {
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setString(1,seatId);
                    ps.setString(2, orderId);
                    ps.setString(3, userId);
                    return ps;
                }
            }, keyHolder);
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }
}

class  SeatRowMapper implements RowMapper<Seat>{

    @Override
    public Seat mapRow(ResultSet resultSet, int i) throws SQLException {
        Seat seat = new Seat();
        seat.setSeatId(resultSet.getString("seat_id"));
        seat.setSeatInfo(resultSet.getString("seat_info"));
        return seat;
    }
}

class SeatScheduleRowMapper implements RowMapper<SeatSchedule>{

    @Override
    public SeatSchedule mapRow(ResultSet resultSet, int i) throws SQLException {
        SeatSchedule seatSchedule = new SeatSchedule();
        seatSchedule.setId(resultSet.getInt("id"));
        seatSchedule.setOrderId(resultSet.getString("order_id"));
        seatSchedule.setSeatId(resultSet.getString("seat_id"));
        seatSchedule.setUserId(resultSet.getString("user_id"));
        return seatSchedule;
    }
}

