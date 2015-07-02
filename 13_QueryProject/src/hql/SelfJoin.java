package hql;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.*;

public class SelfJoin {

	public static void main(String[] args) {
		Session session = null;

		try{
			// This step will read hibernate.cfg.xml and prepare hibernate for use
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			 session =sessionFactory.openSession();
				//Create new instance of Contact and set values in it by reading them from form object
			 	System.out.println("Inserting Record");
				Contact contact;
				
				// String SQL_QUERY ="select c1.firstName, c2.lastName from Contact c1 , Contact c2";
				 //String SQL_QUERY ="select c1.firstName, c2.lastName from Contact c1 , Contact c2 where c1.id=c2.id";
				 String SQL_QUERY ="from hql.Contact c1 join fetch hql.Contact c2 ";
				 
                Query query = session.createQuery(SQL_QUERY);
				Iterator it=query.iterate();
                 while(it.hasNext()){
               Object[] row = (Object[]) it.next();
				  System.out.println("------------------------------------------------------");
				  for(int i=0; i<row.length; i++)
                  {
					//  Contact c=(Contact)row[i];
					  //	System.out.print(c.getFirstName() + ":" + c.getLastName());
					  System.out.println(row[i]+":");
                  }
				  System.out.println();
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
