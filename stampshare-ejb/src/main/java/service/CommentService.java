package service;

import dao.CommentDao;
import dao.StampDao;
import domain.Comment;
import domain.Stamp;
import domain.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/9/13
 * Time: 7:44 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class CommentService {
    @EJB
    private CommentDao commentDao;

    @EJB
    private StampService stampService;

    @EJB
    private UserService userService;

    @TransactionAttribute
    public void addComment(Comment comment, User user, Stamp stamp) {
        stamp = stampService.getStampById(stamp.getId());
        comment.setStamp(stamp);
        List<Comment> commentList = stamp.getCommentList();
        if(commentList == null) {
            commentList = new ArrayList<Comment>();
        }
        commentList.add(comment);
        stamp.setCommentList(commentList);

        user = userService.getUserById(user.getId());
        comment.setUser(user);
        commentList = user.getCommentList();
        if(commentList == null) {
            commentList = new ArrayList<Comment>();
        }
        commentList.add(comment);
        user.setCommentList(commentList);
    }

    public List<Comment> getCommentListByStampId(int stampId) {
        return commentDao.getCommentListByStampId(stampId);
    }
}
