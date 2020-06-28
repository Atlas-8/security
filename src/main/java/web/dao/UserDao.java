package web.dao;

import web.model.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   void deleteUser(long id) throws SQLException;
   void updateUser(User user, long oldId);

}
