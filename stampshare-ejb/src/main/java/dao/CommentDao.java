package dao;

import domain.Comment;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/9/13
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */

@Local
public interface CommentDao {
    List<Comment> getCommentListByStampId(int stampId);
}
