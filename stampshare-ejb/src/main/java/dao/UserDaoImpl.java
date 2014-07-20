package dao;

import domain.Stamp;
import domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/3/13
 * Time: 12:01 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class UserDaoImpl implements UserDao {
    @PersistenceContext(unitName = "persistDB")
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT m FROM User m", User.class);

        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(User user) {
        TypedQuery<User> query = entityManager.createQuery("SELECT m FROM User m WHERE :name = m.name AND :password = m.password", User.class);
        query.setParameter("name", user.getName());
        query.setParameter("password", user.getPassword());

        return query.getResultList().get(0);
    }

    @Override
    public User getUserById(int id) {
        TypedQuery<User> query = entityManager.createQuery("SELECT m FROM User m WHERE :id = m.id", User.class);
        query.setParameter("id", id);

        return query.getResultList().get(0);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<Stamp> getStampListByUserId(int userId) {
        List<User> userList = entityManager.createQuery("SELECT user FROM User user " +
                "JOIN FETCH user.stampList stamp " +
                "WHERE user.id =:id")
                .setParameter("id", userId).getResultList();

        if (userList.size() != 0) {
            return userList.get(0).getStampList();
        } else {
            return new ArrayList<Stamp>();
        }
    }
}
