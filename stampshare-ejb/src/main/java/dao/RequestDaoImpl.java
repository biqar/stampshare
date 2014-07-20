package dao;

import domain.Request;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/9/13
 * Time: 7:46 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class RequestDaoImpl implements RequestDao {
    @PersistenceContext(unitName = "persistDB")
    private EntityManager entityManager;

    @Override
    public List<Request> getRequestListByUserIdStampId(int userId, int stampId) {
        TypedQuery<Request> query = entityManager.createQuery("SELECT request FROM Request request " +
                "WHERE :userId = request.user.id " +
                "AND :stampId = request.stamp.id", Request.class);
        query.setParameter("userId", userId);
        query.setParameter("stampId", stampId);
        List<Request> requestList = query.getResultList();

        if (requestList.size() != 0) {
            return requestList;
        } else {
            return new ArrayList<Request>();
        }
    }

    @Override
    public List<Request> getRequestCountBetweenDates(int stampId, Date start, Date end) {
        List<Request> requestList = entityManager.createQuery("SELECT request FROM Request request " +
                "WHERE request.requestTime BETWEEN :startTime AND :endTime " +
                "AND :stampId = request.stamp.id", Request.class)
                .setParameter("startTime", start)
                .setParameter("endTime", end)
                .setParameter("stampId", stampId)
                .getResultList();

        if (requestList.size() != 0) {
            return requestList;
        } else {
            return new ArrayList<Request>();
        }
    }
}
