package dao;

import domain.ExchangePolicy;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/7/13
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 */

@Local
public interface ExchangePolicyDao {
    List<ExchangePolicy> findAllExchangePolicies();

    ExchangePolicy getExchangePolicyById(Integer id);

    ExchangePolicy getExchangePolicyByName(String exchangePolicyName);

    void update(ExchangePolicy exchangePolicy);
}
