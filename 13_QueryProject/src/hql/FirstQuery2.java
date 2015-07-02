
package hql;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.*;


public class FirstQuery2{
	public static void main(String[] args) {
		Session session = null;

		try{
		
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			 session =sessionFactory.openSession();
		
			 
				Contact contact;
				
				 String SQL_QUERY ="select c.id, c.firstName from Contact  c where c.id >= 3";
				
                Query query = session.createQuery(SQL_QUERY);
				Iterator it=query.iterate();
                 while(it.hasNext()){
               Object[] row = (Object[]) it.next();
				  System.out.println("------------------------------------------------------");
                  System.out.println("ID                : " + row[0]);
                  System.out.println("First Name  : " + row[1]);
                 }
       
                
				System.out.println("Done");
		}catch(Exception e){
			//tx.rollback();
			System.out.println(e.getMessage());
		}finally{
		
			//session.flush();
			session.close();

			}
		
	}
}
