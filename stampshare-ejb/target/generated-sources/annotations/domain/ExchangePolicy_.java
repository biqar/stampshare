package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ExchangePolicy.class)
public abstract class ExchangePolicy_ {

	public static volatile SingularAttribute<ExchangePolicy, Integer> id;
	public static volatile ListAttribute<ExchangePolicy, Stamp> stampList;
	public static volatile SingularAttribute<ExchangePolicy, String> name;

}

