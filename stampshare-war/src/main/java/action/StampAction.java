package action;

import domain.Comment;
import domain.Stamp;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import service.CommentService;
import service.RequestService;
import service.StampService;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/9/13
 * Time: 10:00 AM
 * To change this template use File | Settings | File Templates.
 */

@Named
@SessionScoped
public class StampAction implements Serializable {
    private Stamp stamp;
    private UploadedFile stampImageFile;
    private List<Comment> commentList;

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
        if (commentList == null) {
            commentList = new ArrayList<Comment>();
        }
    }

    public String showStamp(int id) {
        System.out.println("STAMP ID : " + id);

        stamp = stampService.getStampById(id);
        commentList = commentService.getCommentListByStampId(id);

        return "show_individual_stamp.xhtml?faces-redirect=true";
    }

    public String showStampSearch() {
        int id = 1;
        System.out.println("STAMP ID : " + id);

        stamp = stampService.getStampById(id);
        commentList = commentService.getCommentListByStampId(id);

        return "show_individual_stamp";
    }

    public StreamedContent getStampImage() {
        byte[] stampImageData = stamp.getImageData();
        InputStream inputStream = new ByteArrayInputStream(stampImageData);

        return new DefaultStreamedContent(inputStream, "image/jpeg");
    }

    public String updateStampData() {
        stampService.update(stamp);

        return "show_individual_stamp?faces-redirect=true";
    }

    public String updateStampImage() {
        byte[] imageData = stampImageFile.getContents();

        stamp.setImageData(imageData);
        stampService.update(stamp);

        return "show_individual_stamp?faces-redirect=true";
    }

    public Stamp getStamp() {
        return stamp;
    }

    public void setStamp(Stamp stamp) {
        this.stamp = stamp;
    }

    public UploadedFile getStampImageFile() {
        return stampImageFile;
    }

    public void setStampImageFile(UploadedFile stampImageFile) {
        this.stampImageFile = stampImageFile;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
