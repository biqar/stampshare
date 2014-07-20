package domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Comment.class)
public abstract class Comment_ {

	public static volatile SingularAttribute<Comment, String> commentData;
	public static volatile SingularAttribute<Comment, Integer> id;
	public static volatile SingularAttribute<Comment, Stamp> stamp;
	public static volatile SingularAttribute<Comment, Date> commentTime;
	public static volatile SingularAttribute<Comment, User> user;

}

