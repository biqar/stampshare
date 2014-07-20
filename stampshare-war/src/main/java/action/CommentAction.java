package action;

import domain.Comment;
import domain.Stamp;
import domain.User;
import service.CommentService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/9/13
 * Time: 7:42 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@SessionScoped
public class CommentAction implements Serializable {
    private Comment comment;
    private Stamp stamp;
    private User user;

    @Inject
    private StampAction stampAction;

    @EJB
    private CommentService commentService;

    @PostConstruct
    public void startUp() {
        if(comment == null) {
            comment = new Comment();
        }
        if(stamp == null) {
            stamp = new Stamp();
        }
        if(user == null) {
            user = new User();
        }
    }

    public void addComment() {
        setCommentProperty();
        commentService.addComment(comment, user, stamp);
        stampAction.showStamp(stamp.getId());
    }

    private void setCommentProperty() {
        comment.setCommentTime(new Date());
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
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
}
