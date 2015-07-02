package anno;

import hibernate.HibernateUtility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

 
public class Main {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Address address = new Address("OMR Road", "Bangalore", "TN", "300017");
			// By using cascade=all option the address need not be saved
			// explicitly when the student object is persisted the address will
			// be automatically saved.
			//session.save(address);
			Student student1 = new Student("John", address);
			Student student2 = new Student("Joe", address);
			session.save(student1);
			session.save(student2);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
