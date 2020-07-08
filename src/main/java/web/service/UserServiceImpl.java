package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.Role;
import web.model.User;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordEncoder encoder) {
        this.userDao = userDao;
        this.encoder = encoder;
    }

    @Transactional
    @Override
    public void add(User user) {
        User userFromDB = userDao.findByUsername(user.getUsername());
        if (userFromDB != null) {
            throw new RuntimeException("login is already exist");
        }
        user.setRoles(Collections.singleton(new Role(2L, "ROLE_USER")));
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.add(user);
    }

    @Override
    public void madeAdmin(User user){
        userDao.madeAdmin(user);
    }

    public void dismissAdmin(User user){
        userDao.dismissAdmin(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public void deleteUser(long id) throws SQLException {
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(User user, long oldId){
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.updateUser(user, oldId);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userDao.findByUsername(name);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public User getById(long id){
        return userDao.getById(id);
    }
}
