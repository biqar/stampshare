package action;

import domain.User;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/6/13
 * Time: 2:23 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@SessionScoped
public class UserProfileAction implements Serializable {
    private User user;
    private UploadedFile profileImageFile;
    private UIComponent fileUploadComponent;
    private FacesContext facesContext;

    @EJB
    private UserService userService;

    @PostConstruct
    public void startUp() {
        if (user != null) {
            user = new User();
        }
    }

    public String showUserProfile(int id) {
        user = userService.getUserById(id);

        return "show_user_profile?faces-redirect=true";
    }

    public StreamedContent getProfileImage() {
        byte[] profileImageData = user.getImageData();
        InputStream inputStream = new ByteArrayInputStream(profileImageData);

        return new DefaultStreamedContent(inputStream, "image/jpeg");
    }

    public String updateProfileData() {
        userService.update(user);

        return "show_user_profile?faces-redirect=true";
    }

    public String updateProfileImage() {
        if(!isValidImage()) {
            addErrorMessage("Upload File ! Only jpeg, jpg, png, gif are allowed !");
            return "show_user_profile";
        }
        byte[] imageData = profileImageFile.getContents();

        user.setImageData(imageData);
        userService.update(user);

        return "show_user_profile?faces-redirect=true";
    }

    private void addErrorMessage(String message) {
        if(facesContext == null) {
            facesContext = FacesContext.getCurrentInstance();
        }

        FacesMessage invalidFileMessage = new FacesMessage(message);
        facesContext.addMessage(fileUploadComponent.getClientId(facesContext), invalidFileMessage);
    }

    private boolean isValidImage() {
        if(profileImageFile == null) {
            return false;
        }

        String fileName = profileImageFile.getFileName();
        int lastIndexOfDot = fileName.lastIndexOf('.');
        String extension = fileName.substring(lastIndexOfDot + 1);

        return (extension.equals("jpeg") || extension.equals("png") || extension.equals("jpg") || extension.equals("gif"));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UploadedFile getProfileImageFile() {
        return profileImageFile;
    }

    public void setProfileImageFile(UploadedFile profileImageFile) {
        this.profileImageFile = profileImageFile;
    }

    public UIComponent getFileUploadComponent() {
        return fileUploadComponent;
    }

    public void setFileUploadComponent(UIComponent fileUploadComponent) {
        this.fileUploadComponent = fileUploadComponent;
    }

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }
}
