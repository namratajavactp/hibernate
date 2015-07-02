package de.laliluna.search;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class SessionFactoryUtil {
	private static SessionFactory factory;
	
	private SessionFactoryUtil() {
	}
	
	static{
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getFactory(){
		return factory;
	}
	
}
