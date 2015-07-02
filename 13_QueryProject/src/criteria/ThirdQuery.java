
package criteria;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import hibernate.HibernateUtility;

import java.util.*;


public class ThirdQuery{
	public static void main(String[] args) {
		Session session = null;

		try{
			 session =HibernateUtility.getSession();
			 	System.out.println("Fetching Record");
				Contact contact;
				Criteria c = session.createCriteria(criteria.Contact.class);
				
				c.add(Restrictions.eq("firstName", "Raj"));
				   //c.add(Restrictions.like("lastName", "ka%"));
				//c.add(Restrictions.between("id", 2, 4));
				//c.add(Restrictions.eq("firstName", "Raj"));
				// Restrictions.ne(“name”, ”NoName”);
				// Restrictions.like(“name”, “Sa%”);
				// Restrictions.ilike(“name”, “sa%”);
				// Restrictions.isNull(“name”);
				// Restrictions.gt(“price”,new Double(30.0));
				//c.add(Restrictions.between("id", 3, 4));
				
				

				
				
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
