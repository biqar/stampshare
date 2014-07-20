package dao;

import domain.ExchangePolicy;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/7/13
 * Time: 3:30 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class ExchangePolicyDaoImpl implements ExchangePolicyDao {
    @PersistenceContext(unitName = "persistDB")
    private EntityManager entityManager;

    @Override
    public List<ExchangePolicy> findAllExchangePolicies() {
        TypedQuery<ExchangePolicy> query = entityManager.createQuery("SELECT m FROM ExchangePolicy m", ExchangePolicy.class);

        return query.getResultList();
    }

    @Override
    public ExchangePolicy getExchangePolicyById(Integer id) {
        TypedQuery<ExchangePolicy> query = entityManager.createQuery("SELECT m FROM ExchangePolicy m WHERE :id = m.id", ExchangePolicy.class);
        query.setParameter("id", id);

        return query.getResultList().get(0);
    }

    @Override
    public ExchangePolicy getExchangePolicyByName(String exchangePolicyName) {
        TypedQuery<ExchangePolicy> query = entityManager.createQuery("SELECT m FROM ExchangePolicy m WHERE :name = m.name", ExchangePolicy.class);
        query.setParameter("name", exchangePolicyName);

        return query.getResultList().get(0);
    }

    @Override
    public void update(ExchangePolicy exchangePolicy) {
        entityManager.merge(exchangePolicy);
    }
}
