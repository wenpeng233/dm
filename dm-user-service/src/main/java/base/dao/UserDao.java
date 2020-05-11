package base.dao;

import base.dao.mapper.UserMapper;
import base.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserDao implements UserMapper {

//    static {
//        System.setProperty("javax.net.debug", "all");
//    }


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getUser(String userId) {
        String sql = "select * from t_user_info where user_id = ?";
        List<User> users = jdbcTemplate.query(sql, new Object[]{userId},new UserRowMapper());
//        List<User> users = jdbcTemplate.query(sql, new UserRowMapper(), userId);   可以使用
        if (! users.isEmpty()) {
            return users.get(0);
        }
        return new User();
    }

    @Override
    public boolean setUser(User user) {
        return false;
    }
}

class  UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getString("user_id"));
        user.setUserName(resultSet.getString("user_name"));
        return user;
    }
}