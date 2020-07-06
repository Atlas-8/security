package web.dao;

import web.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao/* extends JpaRepository<User, Long> */{
   void add(User user);
   List<User> listUsers();
   void deleteUser(long id) throws SQLException;
   void updateUser(User user, long oldId);
   User findByUsername(String username);
   User getById(long id);
}
