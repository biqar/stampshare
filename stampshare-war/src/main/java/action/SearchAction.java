package action;

import domain.Stamp;
import domain.User;
import model.AdvancedSearchModel;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import service.StampService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/13/13
 * Time: 9:22 AM
 * To change this template use File | Settings | File Templates.
 */

@Named
@RequestScoped
public class SearchAction {
    private String stampName;
    private AdvancedSearchModel advancedSearchModel;
    private List<Stamp> stampList;

    @EJB
    private StampService stampService;

    @PostConstruct
    public void startUp() {
        if(stampList == null) {
            stampList = new ArrayList<Stamp>();
        }

        if(advancedSearchModel == null) {
            advancedSearchModel = new AdvancedSearchModel();
        }
    }

    public String searchByStampName() {
        stampList = stampService.getStampByName(stampName);
        return "show_search_result";
    }

    public String advancedSearch() {
        stampList = stampService.getResultOfAdvancedSearch(advancedSearchModel);
        System.out.println("~~~~SIZE : " + stampList.size());
        return "show_search_result";
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

    public String getStampName() {
        return stampName;
    }

    public void setStampName(String stampName) {
        this.stampName = stampName;
    }

    public List<Stamp> getStampList() {
        return stampList;
    }

    public void setStampList(List<Stamp> stampList) {
        this.stampList = stampList;
    }

    public AdvancedSearchModel getAdvancedSearchModel() {
        return advancedSearchModel;
    }

    public void setAdvancedSearchModel(AdvancedSearchModel advancedSearchModel) {
        this.advancedSearchModel = advancedSearchModel;
    }
}
