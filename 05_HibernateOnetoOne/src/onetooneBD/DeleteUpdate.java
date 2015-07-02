package onetooneBD;

import hibernate.HibernateUtility;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteUpdate {

	
	public static void main(String[] args) {
Session session=HibernateUtility.getSession();
        
        Transaction t=session.beginTransaction();
        Person p1=new Person();
        p1.setPersonId(1);
        Address a1=new Address();
        a1.setAddressId(1);
        
        p1.setAddress(a1);
        
       session.delete(a1);  //commenting this line will throw constraint-violation exception as cascade=save-update
       //for cascade=all comment above line will work
        session.delete(p1);
       
         t.commit();
         

	}

}
