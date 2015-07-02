package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtility 
{
	public static SessionFactory sf;
	static
	{
		sf=new AnnotationConfiguration().addAnnotatedClass(com.model.Course.class).configure().buildSessionFactory();
			//sf=new Configuration().configure().buildSessionFactory();
	}
	
	public static Session getSession()
	{
		Session session=sf.openSession();
		return session;
	}

}
