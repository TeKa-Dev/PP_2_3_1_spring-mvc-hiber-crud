package mvc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mvc.dao.UserDAO;
import mvc.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO dao;

    public UserServiceImpl(UserDAO dao) {
        this.dao = dao;
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        dao.saveUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        dao.deleteUser(id);
    }

    @Transactional
    @Override
    public List<User> getUsers() {
        return dao.getUsers();
    }

    @Transactional
    @Override
    public User getUser(Long id) {
        return dao.getUser(id);
    }
}
