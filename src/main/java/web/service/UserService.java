package web.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import web.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> listUsers();
    void add(User user);
    void deleteUser(long id) throws SQLException;
    void updateUser(User user, long oldId);
    UserDetails loadUserByUsername(String var1) throws UsernameNotFoundException;
    User getById(long id);
    void madeAdmin(User user);
    void dismissAdmin(User user);
}
