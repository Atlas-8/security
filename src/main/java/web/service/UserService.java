package web.service;

import web.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    List<User> listUsers();
    void add(User user);
    void deleteUser(long id) throws SQLException;
    void updateUser(User user, long oldId);
}
