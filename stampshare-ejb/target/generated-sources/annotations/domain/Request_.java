package domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Request.class)
public abstract class Request_ {

	public static volatile SingularAttribute<Request, Integer> id;
	public static volatile SingularAttribute<Request, Stamp> stamp;
	public static volatile SingularAttribute<Request, Date> requestTime;
	public static volatile SingularAttribute<Request, User> user;

}

