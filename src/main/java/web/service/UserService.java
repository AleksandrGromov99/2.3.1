package web.service;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;
@Component
public interface UserService {

    public List<User> getUserList();

    public void saveUser(User user);

    public User getUser(int id);

    public void updateUser(User user);

    public void deleteUser(int id);

}
