package web.dao;

import web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public List<User> getUserList() {
      TypedQuery<User> query = entityManager.createQuery("from User", User.class);
      return query.getResultList();
   }

   @Override
   public User getUser(int id){
      return entityManager.find(User.class, id);
   }

   @Override
   public void saveUser(User user){
      entityManager.persist(user);
   }

   @Override
   public void deleteUser(int id) {
      Query query = entityManager.createQuery("delete from User u where u.id = :id");
      query.setParameter("id", id);
      query.executeUpdate();
   }

   @Override
   public void updateUser(User user){
      entityManager.merge(user);
   }
}
