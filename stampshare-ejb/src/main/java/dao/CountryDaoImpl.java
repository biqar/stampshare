package dao;

import domain.Country;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/7/13
 * Time: 2:29 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class CountryDaoImpl implements CountryDao {
    @PersistenceContext(unitName = "persistDB")
    private EntityManager entityManager;

    @Override
    public List<Country> findAllCountries() {
        TypedQuery<Country> query = entityManager.createQuery("SELECT m FROM Country m", Country.class);

        return query.getResultList();
    }

    @Override
    public Country getCountryById(Integer id) {
        TypedQuery<Country> query = entityManager.createQuery("SELECT m FROM Country m WHERE :id = m.id", Country.class);
        query.setParameter("id", id);

        return query.getResultList().get(0);
    }

    @Override
    public Country getCountryByName(String countryName) {
        TypedQuery<Country> query = entityManager.createQuery("SELECT m FROM Country m WHERE :name = m.name", Country.class);
        query.setParameter("name", countryName);

        return query.getResultList().get(0);
    }

    @Override
    public void update(Country country) {
        entityManager.merge(country);
    }
}
