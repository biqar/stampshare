package action;

import domain.User;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/9/13
 * Time: 1:12 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@SessionScoped
public class HomeAction implements Serializable {
    private List<User> userList;

    @EJB
    UserService userService;

    @PostConstruct
    public void startUp() {
        if(userList == null) {
            userList = userService.getAllUser();
        }
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
