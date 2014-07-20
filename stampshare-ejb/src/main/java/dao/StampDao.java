package dao;

import domain.Country;
import domain.ExchangePolicy;
import domain.Stamp;
import domain.User;
import model.AdvancedSearchModel;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/8/13
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */

@Local
public interface StampDao {
    Stamp getStampById(int stampId);

    void update(Stamp stamp);

    User getUserByStampId(int stampId);

    Country getCountryByStampId(int stampId);

    ExchangePolicy getExchangePolicyByStampId(int stampId);

    List<Stamp> getAllStamp();

    List<Stamp> getStampByName(String stampName);

    List<Stamp> getResultOfAdvancedSearch(AdvancedSearchModel advancedSearchModel);
}
