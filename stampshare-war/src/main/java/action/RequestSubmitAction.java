package action;

import domain.Request;
import domain.Stamp;
import domain.User;
import service.CommentService;
import service.RequestService;
import service.StampService;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/10/13
 * Time: 12:59 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@RequestScoped
public class RequestSubmitAction implements Serializable {
    private Stamp stamp;
    private User user;
    private Request request;

    @EJB
    private StampService stampService;

    @EJB
    private CommentService commentService;

    @EJB
    private UserService userService;

    @EJB
    private RequestService requestService;

    @PostConstruct
    public void startUp() {
        if (stamp == null) {
            stamp = new Stamp();
        }
        if (user == null) {
            user = new User();
        }
        if (request == null) {
            request = new Request();
        }
    }

    public boolean isValidToRequest(int userId, int stampId) {
        user = userService.getUserById(userId);
        stamp = stampService.getStampById(stampId);
        List<Request> requestList = requestService.getRequestListByUserIdStampId(userId, stampId);

        return requestList.size() == 0;
    }

    public String sendRequest() {
        setRequestProperty();
        requestService.addRequest(request, user, stamp);

        return "show_individual_stamp?faces-redirect=true";
    }

    private void setRequestProperty() {
        request.setRequestTime(new Date());
    }

    public Stamp getStamp() {
        return stamp;
    }

    public void setStamp(Stamp stamp) {
        this.stamp = stamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
