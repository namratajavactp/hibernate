package onetomany;

import hibernate.HibernateUtility;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class deleteusingload {

	
	public static void main(String[] args) {
 Session session=HibernateUtility.getSession();
        
 Transaction t=session.beginTransaction();   
         
     	 Person p=(Person)session.get(Person.class, 2l);
 		  session.delete(p);
 	 
 		
 		t.commit();
 		 
 		session.close();
	}

}
