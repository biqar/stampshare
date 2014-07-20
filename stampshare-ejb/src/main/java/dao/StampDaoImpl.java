package dao;

import domain.Country;
import domain.ExchangePolicy;
import domain.Stamp;
import domain.User;
import model.AdvancedSearchModel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/8/13
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class StampDaoImpl implements StampDao {
    @PersistenceContext(unitName = "persistDB")
    private EntityManager entityManager;

    @Override
    public Stamp getStampById(int stampId) {
        TypedQuery<Stamp> query = entityManager.createQuery("SELECT stamp FROM Stamp stamp WHERE :id = stamp.id", Stamp.class);
        query.setParameter("id", stampId);

        return query.getResultList().get(0);
    }

    @Override
    public void update(Stamp stamp) {
        entityManager.merge(stamp);
    }

    @Override
    public User getUserByStampId(int stampId) {
        List<Stamp> stampList = entityManager.createQuery("SELECT stamp FROM Stamp stamp " +
                "JOIN FETCH stamp.user user " +
                "WHERE stamp.id =:id", Stamp.class)
                .setParameter("id", stampId).getResultList();

        return stampList.get(0).getUser();
    }

    @Override
    public Country getCountryByStampId(int stampId) {
        List<Stamp> stampList = entityManager.createQuery("SELECT stamp FROM Stamp stamp " +
                "JOIN FETCH stamp.country country " +
                "WHERE stamp.id =:id", Stamp.class)
                .setParameter("id", stampId).getResultList();

        return stampList.get(0).getCountry();
    }

    @Override
    public ExchangePolicy getExchangePolicyByStampId(int stampId) {
        List<Stamp> stampList = entityManager.createQuery("SELECT stamp FROM Stamp stamp " +
                "JOIN FETCH stamp.exchangePolicy exchangePolicy " +
                "WHERE stamp.id =:id", Stamp.class)
                .setParameter("id", stampId).getResultList();

        return stampList.get(0).getExchangePolicy();
    }

    @Override
    public List<Stamp> getAllStamp() {
        TypedQuery<Stamp> query = entityManager.createQuery("SELECT stamp FROM Stamp stamp", Stamp.class);

        return query.getResultList();
    }

    @Override
    public List<Stamp> getStampByName(String stampName) {
        TypedQuery<Stamp> query = entityManager.createQuery("SELECT stamp FROM Stamp stamp WHERE :name = stamp.name", Stamp.class);
        query.setParameter("name", stampName);

        return query.getResultList();
    }

    @Override
    public List<Stamp> getResultOfAdvancedSearch(AdvancedSearchModel advancedSearchModel) {
        List<Stamp> stampList = entityManager.createQuery("SELECT stamp FROM Stamp stamp " +
                "WHERE stamp.year BETWEEN :stampYearFrom AND :stampYearTo " +
                "AND :stampCountryName = stamp.country.name " +
                "AND stamp.rating BETWEEN :stampRatingFrom AND :stampRatingTo " +
                "AND :stampExchangePolicyName = stamp.exchangePolicy.name", Stamp.class)
                .setParameter("stampYearFrom", advancedSearchModel.getStampYearFrom())
                .setParameter("stampYearTo", advancedSearchModel.getStampYearTo())
                .setParameter("stampCountryName", advancedSearchModel.getStampCountryName())
                .setParameter("stampRatingFrom", advancedSearchModel.getStampRatingFrom())
                .setParameter("stampRatingTo", advancedSearchModel.getStampRatingTo())
                .setParameter("stampExchangePolicyName", advancedSearchModel.getStampExchangePolicyName())
                .getResultList();

        if (stampList.size() != 0) {
            return stampList;
        } else {
            return new ArrayList<Stamp>();
        }
    }
}
