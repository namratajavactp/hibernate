package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility 
{
	private static SessionFactory sf;
	static
	{
		  Configuration cfg=new Configuration();
		  cfg.addResource("emp/employee.hbm.xml");
			sf= cfg.buildSessionFactory();
			
	}
	
	public static Session getSession()
	{
		Session session=sf.openSession();
		return session;
	}

}
