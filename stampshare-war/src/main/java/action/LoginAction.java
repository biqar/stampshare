package action;

import domain.User;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/6/13
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@SessionScoped
public class LoginAction implements Serializable {
    private static final Integer USER_ADMIN = 0;

    private User user;
    private HttpSession session;

    @EJB
    UserService userService;

    @PostConstruct
    public void startUp() {
        if (user == null) {
            user = new User();
        }
    }

    public String login() {
        if (user != null) {
            user = userService.loginService(user);

            if (user != null) {
                FacesContext facesContext = FacesContext.getCurrentInstance();
                ExternalContext externalContext = facesContext.getExternalContext();
                session = (HttpSession) externalContext.getSession(true);

                session.setAttribute("user", user);
            }
        }
        return "home.xhtml?faces-redirect=true";
    }

    public String destroySession() {
        if (user != null) {
            session.removeAttribute("user");
            session.invalidate();
        }

        return "index.xhtml?faces-redirect=true";
    }

    public boolean isAdmin() {
        return USER_ADMIN.equals(user.getType());
    }

    public boolean isLoggedIn() {
        return user.getId() != null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
