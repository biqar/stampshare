package action;

import domain.Stamp;
import domain.User;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import service.StampService;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/8/13
 * Time: 6:02 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@SessionScoped
public class StampAlbumAction implements Serializable {
    private User user;
    private List<Stamp> stampList;

    @EJB
    private StampService stampService;

    @EJB
    private UserService userService;

    @PostConstruct
    public void startUp() {
        if (user == null) {
            user = new User();
        }

        if (stampList == null) {
            stampList = new ArrayList<Stamp>();
        }
    }

    //This method will need to show stamp in user stamp album
    public Stamp getStampById(int stampId) {
        return stampService.getStampById(stampId);
    }

    public StreamedContent getStampImage() {
        FacesContext facesContext = FacesContext.getCurrentInstance();

        if(facesContext.getRenderResponse()) {
            return new DefaultStreamedContent();
        }
        else {
            int stampId = Integer.valueOf(facesContext.getExternalContext().getRequestParameterMap().get("id"));
            Stamp stamp = stampService.getStampById(stampId);
            byte[] stampImageData = stamp.getImageData();
            InputStream inputStream = new ByteArrayInputStream(stampImageData);

            return new DefaultStreamedContent(inputStream, "image/jpeg");
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Stamp> getStampList() {
        return userService.getStampListByUserId(user.getId());
    }

    public void setStampList(List<Stamp> stampList) {
        this.stampList = stampList;
    }
}
