package service;

import dao.RequestDao;
import domain.Request;
import domain.Stamp;
import domain.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/9/13
 * Time: 7:44 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class RequestService {
    @EJB
    private RequestDao requestDao;

    @EJB
    private StampService stampService;

    @EJB
    private UserService userService;

    public List<Request> getRequestListByUserIdStampId(int userId, int stampId) {
        return requestDao.getRequestListByUserIdStampId(userId, stampId);
    }

    public List<Request> getRequestCountBetweenDates(int stampId, Date start, Date end) {
        return requestDao.getRequestCountBetweenDates(stampId, start, end);
    }

    @TransactionAttribute
    public void addRequest(Request request, User user, Stamp stamp) {
        stamp = stampService.getStampById(stamp.getId());
        request.setStamp(stamp);
        List<Request> requestList = stamp.getRequestList();
        if(requestList == null) {
            requestList = new ArrayList<Request>();
        }
        requestList.add(request);
        stamp.setRequestList(requestList);

        user = userService.getUserById(user.getId());
        request.setUser(user);
        requestList = user.getRequestList();
        if(requestList == null) {
            requestList = new ArrayList<Request>();
        }
        requestList.add(request);
        user.setRequestList(requestList);
    }
}
