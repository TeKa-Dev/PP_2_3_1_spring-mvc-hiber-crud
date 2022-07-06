package mvc.dao;

import mvc.model.User;

import java.util.List;

public interface UserDAO {

    void saveUser(User user);

    User getUser(Long id);

    void deleteUser(Long id);

    List<User> getUsers();
}
