package dao;

import domain.Comment;
import domain.Stamp;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/9/13
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class CommentDaoImpl implements CommentDao {
    @PersistenceContext(unitName = "persistDB")
    private EntityManager entityManager;

    @Override
    public List<Comment> getCommentListByStampId(int stampId) {
        List<Stamp> stampList = entityManager.createQuery("SELECT stamp FROM Stamp stamp " +
                "JOIN FETCH stamp.commentList comment " +
                "WHERE stamp.id =:id")
                .setParameter("id", stampId).getResultList();

        if (stampList.size() != 0) {
            return stampList.get(0).getCommentList();
        } else {
            System.out.println("got caught !");
            return new ArrayList<Comment>();
        }
    }
}
