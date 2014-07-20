package service;

import dao.StampDao;
import domain.Country;
import domain.ExchangePolicy;
import domain.Stamp;
import domain.User;
import model.AdvancedSearchModel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/8/13
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class StampService {
    @EJB
    private StampDao stampDao;

    @EJB
    private CountryService countryService;

    @EJB
    private ExchangePolicyService exchangePolicyService;

    @EJB
    private UserService userService;

    @TransactionAttribute
    public void addStamp(Stamp stamp, String countryName, String exchangePolicyName, User user) {
        Country country = countryService.getCountryByName(countryName);
        stamp.setCountry(country);
        List<Stamp> stampList = country.getStampList();
        if (stampList == null) {
            stampList = new ArrayList<Stamp>();
        }
        stampList.add(stamp);
        country.setStampList(stampList);

        ExchangePolicy exchangePolicy = exchangePolicyService.getExchangePolicyByName(exchangePolicyName);
        stamp.setExchangePolicy(exchangePolicy);
        stampList = exchangePolicy.getStampList();
        if (stampList == null) {
            stampList = new ArrayList<Stamp>();
        }
        stampList.add(stamp);
        exchangePolicy.setStampList(stampList);

        user = userService.getUserById(user.getId());
        stamp.setUser(user);
        stampList = user.getStampList();
        if (stampList == null) {
            stampList = new ArrayList<Stamp>();
        }
        stampList.add(stamp);
        user.setStampList(stampList);
    }

    public List<Stamp> getAllStamp() {
        return stampDao.getAllStamp();
    }

    public Stamp getStampById(int stampId) {
        return stampDao.getStampById(stampId);
    }

    public void update(Stamp stamp) {
        stampDao.update(stamp);
    }

    public User getUserByStampId(int stampId) {
        return stampDao.getUserByStampId(stampId);
    }

    public Country getCountryByStampId(int stampId) {
        return stampDao.getCountryByStampId(stampId);
    }

    public ExchangePolicy getExchangePolicyByStampId(int stampId) {
        return stampDao.getExchangePolicyByStampId(stampId);
    }

    public List<Stamp> getStampByName(String stampName) {
        return stampDao.getStampByName(stampName);
    }

    public List<Stamp> getResultOfAdvancedSearch(AdvancedSearchModel advancedSearchModel) {
        return stampDao.getResultOfAdvancedSearch(advancedSearchModel);
    }
}
