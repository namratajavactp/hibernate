package onetomanyBD;

import hibernate.HibernateUtility;


import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmpUpdateDelete {

	public static void main(String[] args) 
	{
		
		Session session=HibernateUtility.getSession();
		Transaction tx= session.beginTransaction();
		
 //cascade=delete will work only if persistence object is loaded into the primary cache
		Person p=(Person)session.load(Person.class, 1l);
		 
		
	
		session.delete(p);
		tx.commit();
		 
		session.close();
			
		
	}
}
