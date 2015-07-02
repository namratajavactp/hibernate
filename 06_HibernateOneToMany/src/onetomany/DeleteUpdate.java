package onetomany;

import hibernate.HibernateUtility;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteUpdate {

	
	public static void main(String[] args) {
Session session=HibernateUtility.getSession();
        
        Transaction t=session.beginTransaction();
         /*Person p=new Person();
         p.setPersonId(2l);
     	  session.delete(p);*/
         Address a=new Address();
         a.setAddressId(201);
         session.delete(a);
 		
 		t.commit();
 		 
 		session.close();
	}

}
