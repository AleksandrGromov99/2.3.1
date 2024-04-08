package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

   public List<User> getUserList();

   public User getUser(int id);

   public void saveUser(User user);

   public void deleteUser(int id);

   public void updateUser(User user);
}

