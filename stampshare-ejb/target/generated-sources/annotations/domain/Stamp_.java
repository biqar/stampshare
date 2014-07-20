package domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Stamp.class)
public abstract class Stamp_ {

	public static volatile SingularAttribute<Stamp, Integer> id;
	public static volatile ListAttribute<Stamp, Request> requestList;
	public static volatile SingularAttribute<Stamp, byte[]> imageData;
	public static volatile SingularAttribute<Stamp, Integer> count;
	public static volatile SingularAttribute<Stamp, String> name;
	public static volatile SingularAttribute<Stamp, ExchangePolicy> exchangePolicy;
	public static volatile SingularAttribute<Stamp, Date> addDate;
	public static volatile SingularAttribute<Stamp, Integer> year;
	public static volatile SingularAttribute<Stamp, Double> rating;
	public static volatile SingularAttribute<Stamp, User> user;
	public static volatile ListAttribute<Stamp, Comment> commentList;
	public static volatile SingularAttribute<Stamp, Country> country;

}

