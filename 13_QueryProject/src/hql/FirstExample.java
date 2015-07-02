
package hql;

import hibernate.HibernateUtility;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;



public class FirstExample {
	public static void main(String[] args) {
		
		Session session=null;
		try{
			
			 session =HibernateUtility.getSession();
				//Create new instance of Contact and set values in it by reading them from form object
			 	System.out.println("Inserting Record");
				Transaction tx=session.beginTransaction();
				
				Contact contact1 = new Contact();
				contact1.setId(1L);
				contact1.setFirstName("sanjay");
				contact1.setLastName("dutt");
				contact1.setEmail("sanjay@yahoo.com");
				session.save(contact1);
				
				Contact contact2 = new Contact();
				contact2.setId(2L);
				contact2.setFirstName("Raj");
				contact2.setLastName("Kapoor");
				contact2.setEmail("raj@rediff.com");
				session.save(contact2);
				
				Contact contact3 = new Contact();
				contact3.setId(3l);
				contact3.setFirstName("Boney");
				contact3.setLastName("Kapoor");
				contact3.setEmail("boney@yahoo.com");
				session.save(contact3);
				
				Contact contact4 = new Contact();
				contact4.setId(4l);
				contact4.setFirstName("Raj");
				contact4.setLastName("babbar");
				contact4.setEmail("raj@yahoo.com");
				session.save(contact4);
				tx.commit();
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
