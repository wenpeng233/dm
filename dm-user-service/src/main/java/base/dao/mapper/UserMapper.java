package base.dao.mapper;

import base.entity.User;

public interface UserMapper {

    User getUser(String userId);

    boolean setUser(User user);
}
