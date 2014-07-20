package action;

import domain.User;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/3/13
 * Time: 12:28 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@RequestScoped
public class UserRegisterAction {
    private static final Integer USER_REGISTERED = 1;
    private static final String DEFAULT_USER_IMAGE_FILE = "/home/raqibul/IdeaProjects/stampshare/stampshare-war/src/main/webapp/resources/img/user_default.jpg";

    private User user;

    @EJB
    private UserService userService;

    @PostConstruct
    public void startUp() {
        if (user == null) {
            user = new User();
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String registerUser() {
        byte[] imageData = getDefaultImageData();

        user.setImageData(imageData);
        user.setType(USER_REGISTERED);
        user.setJoinDate(new Date());

        userService.addUser(user);
        return "index?faces-redirect=true";
    }

    private byte[] getDefaultImageData() {
        File file = new File(DEFAULT_USER_IMAGE_FILE);
        byte[] imageData = new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(imageData);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageData;
    }
}
