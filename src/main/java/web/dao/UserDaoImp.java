package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   EntityManager entityManager;

   @Override
   public void add(User user) {
      entityManager.persist(user);
   }

   @Override
   public List<User> listUsers() {
      return entityManager.createQuery("from User").getResultList();
   }

   @Override
   @Transactional
   public void deleteUser(long id) throws SQLException {
      String sql = "delete from users231 where id=" + id;
      entityManager.createNativeQuery(sql).executeUpdate();
   }

   @Override
   @Transactional
   public void updateUser(User user, long oldId){
      entityManager.createQuery("UPDATE User SET id =:id, name =:name, adress =:adress, email =:email where id = :oldId")
              .setParameter("id", user.getId())
              .setParameter("name", user.getName())
              .setParameter("adress", user.getAdress())
              .setParameter("email", user.getEmail())
              .setParameter("oldId", oldId)
              .executeUpdate();
   }
}
