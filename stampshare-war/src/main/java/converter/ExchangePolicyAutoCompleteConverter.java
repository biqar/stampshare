package converter;

import domain.ExchangePolicy;
import service.ExchangePolicyService;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/8/13
 * Time: 9:40 AM
 * To change this template use File | Settings | File Templates.
 */

@FacesConverter("exchangePolicyAutoCompleteConverter")
public class ExchangePolicyAutoCompleteConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String submittedValue) {
        boolean validationStatus = FacesContext.getCurrentInstance().isValidationFailed();

        if(!validationStatus) {
            return null;
        }
        ExchangePolicy exchangePolicy = new ExchangePolicy();
        exchangePolicy.setName(submittedValue);

        return exchangePolicy;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        if(object==null || object.equals("")) {
            return "";
        }
        else {
            return String.valueOf(((ExchangePolicy) object).getName());
        }
    }
}
