package onetoonesimple;

import hibernate.HibernateUtility;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteUpdate {

	
	public static void main(String[] args) {
Session session=HibernateUtility.getSession();
        
        Transaction t=session.beginTransaction();
      
        Person p1=(Person)session.load(Person.class,1L);
       
        Address a1=p1.getAddress();
        System.out.println(a1.getStreetName());
        
        /*
        Person p2=a1.getPerson();
        System.out.println(p2.getName());
        
         session.delete(p1);
       */
         t.commit();
         

	}

}
