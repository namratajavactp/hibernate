
package hql;

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
			//	String SQL_QUERY ="from hql.Contact";
				//String SQL_QUERY ="from Contact where id >= 3";
				// String SQL_QUERY="from Contact c  order by c.firstName desc";
			  //   String SQL_QUERY="from Contact c  where c.email like '%yahoo.com'";

                Query query = session.createQuery("from hql.Contact");
				Iterator it=query.iterate();
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
			//session.flush();
			session.close();

			}
		
	}
}
