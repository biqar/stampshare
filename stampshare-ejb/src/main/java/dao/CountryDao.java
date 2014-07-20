package dao;

import domain.Country;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/7/13
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */

@Local
public interface CountryDao {
    List<Country> findAllCountries();

    Country getCountryById(Integer id);

    Country getCountryByName(String countryName);

    void update(Country country);
}
