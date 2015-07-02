package one2manyanno;

import java.util.HashSet;
import java.util.Set;

 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

 
public class Main {

	public static void main(String[] args) {
        Session session=HibernateUtility.getSession();
        
        Transaction transaction=session.beginTransaction();
		try {
			transaction = session.beginTransaction();

			Set<Phone> phoneNumbers = new HashSet<Phone>();
			phoneNumbers.add(new Phone("house", "32354353"));
			phoneNumbers.add(new Phone("mobile", "9889349983"));

			Student student = new Student("Jahn", phoneNumbers);
			session.save(student);
			
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
