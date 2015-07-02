package setbidirectional;

import hibernate.HibernateUtility;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteUpdate {

	
	public static void main(String[] args) {
Session session=HibernateUtility.getSession();
        
        Transaction t=session.beginTransaction();
        Person p1=(Person)session.get(Person.class, 1L);
        p1.setPersonId(1);
         
        session.delete(p1);
       
         t.commit();
         

	}

}
