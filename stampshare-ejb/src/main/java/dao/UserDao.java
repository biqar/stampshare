package dao;

import domain.Request;
import domain.Stamp;
import domain.User;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/3/13
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */

@Local
public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    User getUser(User user);

    User getUserById(int id);

    void update(User user);

    List<Stamp> getStampListByUserId(int userId);
}
