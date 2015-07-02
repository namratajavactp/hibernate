
package criteria;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import hibernate.HibernateUtility;

import java.util.*;


public class FirstQuery{
	public static void main(String[] args) {
		Session session = null;

		try{
			 session =HibernateUtility.getSession();
			 	System.out.println("Fetching Record");
				Contact contact;
				System.out.println("before creating");
                Criteria c = session.createCriteria(criteria.Contact.class);
				List l= c.list();
				Iterator it=l.iterator();
                 while(it.hasNext()){
               contact=(Contact)it.next();
				  System.out.println("---------------------------------------------------------");
                  System.out.print("    " + contact.getId());
                  System.out.print("    " + contact.getFirstName());
			  System.out.print("        "+contact.getLastName());
		  System.out.print("            "+contact.getEmail()+"\n");
                 }
       
                System.out.println("Done");
		}catch(Exception e){
			//tx.rollback();
			System.out.println(e.getMessage());
		}finally{
			// Actual contact insertion will happen at this step
			session.flush();
			session.close();

			}
		
	}
}
