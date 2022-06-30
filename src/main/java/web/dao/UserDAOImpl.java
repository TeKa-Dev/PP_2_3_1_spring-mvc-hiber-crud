package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManagerFactory factory;

    public UserDAOImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public void saveUser(User user) {
        factory.createEntityManager().persist(user);
    }

    @Override
    public User getUser(Long id) {
        return factory.createEntityManager().find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        factory.createEntityManager().merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        EntityManager em = factory.createEntityManager();
        em.remove(em.find(User.class, id));
    }

    @Override
    public List<User> getUsers() {
        return factory.createEntityManager().createQuery("from User", User.class).getResultList();
    }
}
