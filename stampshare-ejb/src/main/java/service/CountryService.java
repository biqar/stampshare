package service;

import dao.CountryDao;
import domain.Country;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/7/13
 * Time: 2:27 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class CountryService {
    @EJB
    private CountryDao countryDao;

    public List<Country> findAllCountries() {
        return countryDao.findAllCountries();
    }

    public Country getCountryById(Integer id) {
        return countryDao.getCountryById(id);
    }

    public Country getCountryByName(String countryName) {
        return countryDao.getCountryByName(countryName);
    }

    public void update(Country country) {
        countryDao.update(country);
    }
}
