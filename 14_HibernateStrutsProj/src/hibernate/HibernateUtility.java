package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility 
{
	private static SessionFactory sf;
	static
	{
		try
		{
			
		
			sf=new Configuration().configure().buildSessionFactory();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static Session getSession()
	{
		Session session=sf.openSession();
		return session;
	}

}
