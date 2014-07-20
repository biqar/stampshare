package domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, Date> joinDate;
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile ListAttribute<User, Request> requestList;
	public static volatile ListAttribute<User, Stamp> stampList;
	public static volatile SingularAttribute<User, byte[]> imageData;
	public static volatile SingularAttribute<User, String> phoneNumber;
	public static volatile SingularAttribute<User, String> address;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, Integer> type;
	public static volatile SingularAttribute<User, String> password;
	public static volatile ListAttribute<User, Comment> commentList;

}

