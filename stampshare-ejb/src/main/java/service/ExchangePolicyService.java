package service;

import dao.ExchangePolicyDao;
import domain.ExchangePolicy;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/7/13
 * Time: 3:28 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class ExchangePolicyService {
    @EJB
    ExchangePolicyDao exchangePolicyDao;

    public List<ExchangePolicy> findAllExchangePolicies() {
        return exchangePolicyDao.findAllExchangePolicies();
    }

    public ExchangePolicy getExchangePolicyById(Integer id) {
        return exchangePolicyDao.getExchangePolicyById(id);
    }

    public ExchangePolicy getExchangePolicyByName(String exchangePolicyName) {
        return exchangePolicyDao.getExchangePolicyByName(exchangePolicyName);
    }

    public void update(ExchangePolicy exchangePolicy) {
        exchangePolicyDao.update(exchangePolicy);
    }
}
