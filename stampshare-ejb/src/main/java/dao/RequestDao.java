package dao;

import domain.Request;

import javax.ejb.Local;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/9/13
 * Time: 7:46 PM
 * To change this template use File | Settings | File Templates.
 */

@Local
public interface RequestDao {
    List<Request> getRequestListByUserIdStampId(int userId, int stampId);

    List<Request> getRequestCountBetweenDates(int stampId, Date start, Date end);
}
