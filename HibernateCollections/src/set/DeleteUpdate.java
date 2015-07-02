package set;

import hibernate.HibernateUtility;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteUpdate {

	
	public static void main(String[] args) {
Session session=HibernateUtility.getSession();
        
        Transaction t=session.beginTransaction();
        Person p1=new Person();
        p1.setPersonId(4);
        p1.setName("emp26");
         
        session.saveOrUpdate(p1);
       
         t.commit();
         

	}

}
