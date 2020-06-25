package web.dao;


import org.springframework.stereotype.Component;
import web.model.User;
import javax.persistence.NoResultException;
import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

}
