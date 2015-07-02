package componentmapping;

 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

 
public class Main {

	public static void main(String[] args) {
Session session=HibernateUtility.getSession();
        
        Transaction transaction=session.beginTransaction();
		try {
			transaction = session.beginTransaction();
			Address address = new Address("OMR Road", "Chennai", "TN", "600097");
			Student student = new Student("Eswar", address);
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
