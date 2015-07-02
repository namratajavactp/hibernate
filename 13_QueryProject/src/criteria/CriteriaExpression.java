
package criteria;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

import hibernate.HibernateUtility;

import java.util.*;


public class CriteriaExpression{
	public static void main(String[] args) {
		Session session = null;

		try{
			 session =HibernateUtility.getSession();
			 	System.out.println("Fetching Record");
				Contact contact;
				System.out.println("before creating");
				
                Criteria c = session.createCriteria(criteria.Contact.class);
                c.add(Expression.and(Expression.gt("id", 21), Expression.lt("id", 51)));
                
              //  c.add(Expression.and(Expression.gt("id", 1), Expression.lt("id", 3)));
              //session.get(Contact.class, 1);
				List l= c.list();
				System.out.println(l.size());
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
