
package hql;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.*;


public class FirstQueryGroup{
	public static void main(String[] args) {
		Session session = null;

		try{
			// This step will read hibernate.cfg.xml and prepare hibernate for use
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			 session =sessionFactory.openSession();
				//Create new instance of Contact and set values in it by reading them from form object
			 	System.out.println("Inserting Record");
				Contact contact;
				
				 String SQL_QUERY ="select count(*),c.firstName from Contact  c group by c.firstName";

				
                Query query = session.createQuery(SQL_QUERY);
				Iterator it=query.iterate();
                 while(it.hasNext()){
               Object[] row = (Object[]) it.next();
				  System.out.println("------------------------------------------------------");
                  System.out.println("count of " + row[1] + " is : " + row[0]);
	
                 }
       
                
				System.out.println("Done");
		}catch(Exception e){
			//tx.rollback();
			System.out.println(e);
		}finally{
			// Actual contact insertion will happen at this step
			session.flush();
			session.close();

			}
		
	}
}
