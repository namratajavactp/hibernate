
package criteria;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import hibernate.HibernateUtility;

import java.util.*;


public class QueryByExample{
	public static void main(String[] args) {
		Session session = null;

		try{
			 session =HibernateUtility.getSession();
			 	System.out.println("Fetching Record");
				Contact contact;
				System.out.println("before creating");
				
				Contact c=new Contact();
				c.setFirstName("shekhar");
				c.setLastName("suman");
				
				Contact c2=new Contact();
				c2.setFirstName("Raj");
				c2.setLastName("babbar");
				
				Example ex= Example.create(c);
				Example ex1= Example.create(c2);
				
				Criteria c1 = session.createCriteria(criteria.Contact.class);
				
				c1.add(Expression.or(ex, ex1));
				
				
                //c.setFirstResult(2);  // 3rd row will be first record
                //c.setMaxResults(2);
                //c.addOrder(Order.desc("firstName"));
				List l= c1.list();
			
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
