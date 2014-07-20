package action;

import domain.Stamp;
import domain.User;
import org.primefaces.model.UploadedFile;
import service.StampService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/7/13
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */

@Named
@RequestScoped
public class StampAddingAction implements Serializable {
    private User user;
    private String countryName;
    private String exchangePolicyName;
    private Stamp stamp;
    private UploadedFile stampImageFile;
    private UIComponent fileUploadComponent;
    private FacesContext facesContext;

    @EJB
    StampService stampService;

    @PostConstruct
    public void startUp() {
        if (stamp == null) {
            stamp = new Stamp();
        }

        if (user == null) {
            user = new User();
        }
    }

    public String addStamp() {
        setStampAddDate();

        if(!isValidImage()) {
            addErrorMessage("Upload File ! Only jpeg, jpg, png, gif are allowed !");
            return "add_stamp";
        }
        else {
            setStampImageData();
        }

        stampService.addStamp(stamp, countryName, exchangePolicyName, user);

        return "home.xhtml?faces-redirect=true";
    }

    private void addErrorMessage(String message) {
        if(facesContext == null) {
            facesContext = FacesContext.getCurrentInstance();
        }

        FacesMessage invalidFileMessage = new FacesMessage(message);
        facesContext.addMessage(fileUploadComponent.getClientId(facesContext), invalidFileMessage);
    }

    private boolean isValidImage() {
        if(stampImageFile == null) {
            return false;
        }

        String fileName = stampImageFile.getFileName();
        int lastIndexOfDot = fileName.lastIndexOf('.');
        String extension = fileName.substring(lastIndexOfDot + 1);

        return (extension.equals("jpeg") || extension.equals("png") || extension.equals("jpg") || extension.equals("gif"));
    }

    private void setStampImageData() {
        stamp.setImageData(stampImageFile.getContents());
    }

    private void setStampAddDate() {
        stamp.setAddDate(new Date());
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getExchangePolicyName() {
        return exchangePolicyName;
    }

    public void setExchangePolicyName(String exchangePolicyName) {
        this.exchangePolicyName = exchangePolicyName;
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
