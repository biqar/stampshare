package service;

import dao.UserDao;
import domain.Stamp;
import domain.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/3/13
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class UserService {
    @EJB
    private UserDao userDao;

    public List<User> findAllUsers() {
        return userDao.getAllUsers();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addUser(User user) {
        userDao.addUser(user);
    }

    public User loginService(User user) {
        user = userDao.getUser(user);

        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void update(User user) {
        userDao.update(user);
    }

    public List<Stamp> getStampListByUserId(Integer userId) {
        return userDao.getStampListByUserId(userId);
    }

    public List<User> getAllUser() {
        return userDao.getAllUsers();
    }
}
