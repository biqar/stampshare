package converter;

import dao.CountryDao;
import domain.Country;
import service.CountryService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/8/13
 * Time: 9:39 AM
 * To change this template use File | Settings | File Templates.
 */

@FacesConverter("countryAutoCompleteConverter")
public class CountryAutoCompleteConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String submittedValue) {
        boolean validationStatus = FacesContext.getCurrentInstance().isValidationFailed();

        if(!validationStatus) {
            return null;
        }
        Country country = new Country();
        country.setName(submittedValue);

        return country;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        if(object==null || object.equals("")) {
            return "";
        }
        else {
            return String.valueOf(((Country) object).getName());
        }
    }
}
