package list;

import hibernate.HibernateUtility;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main1 {
	public static void main(String arg[]){
		Session session=HibernateUtility.getSession();
        
        Transaction t=session.beginTransaction();
        Person p1=new Person();
        p1.setPersonId(1);
       // Address a= new Address();
       // a.setAddressId(201);
        session.delete(p1);
        t.commit();
	}
}
