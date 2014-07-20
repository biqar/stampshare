package action;

import domain.Country;
import service.CountryService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/7/13
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@RequestScoped
public class CountryAction {
    private List<Country> countryList;

    @EJB
    CountryService countryService;

    @PostConstruct
    public void startUp() {
        if(countryList == null) {
            countryList = countryService.findAllCountries();
        }
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }
}
