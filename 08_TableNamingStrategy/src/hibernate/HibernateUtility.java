package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.strategy.MyNamingStrategy;

public class HibernateUtility 
{
	private static SessionFactory sf;
	static
	{
		sf=new Configuration().setNamingStrategy(new MyNamingStrategy()).configure().buildSessionFactory();
	}
	
	public static Session getSession()
	{
		Session session=sf.openSession();
		return session;
	}

}
