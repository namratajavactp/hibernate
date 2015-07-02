package ontooneAnno;
 
 
import hibernate.HibernateUtility;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

 
public class Main {

	public static void main(String[] args) {
		Session session= new AnnotationConfiguration().configure("hibernate-annotation.cfg.xml").buildSessionFactory().openSession();
        
        Transaction transaction=session.beginTransaction();
		try {
			transaction = session.beginTransaction();
			Address address1 = new Address("BJI Road", "Mumbai", "TN", "300097");
			Address address2 = new Address("Ring Road", "Banglore", "Karnataka", "560000");
			
			
			Student student1 = new Student("Jahn", address1);
			Student student2 = new Student("Joe", address2);
			
		//	student1.setStudentAddress(address1);
		//	student2.setStudentAddress(address2);
			
			
			session.save(student1);
			session.save(student2);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
/*		//.........................
Session session1=HibernateUtility.getSession();
        
        Transaction transaction1=session1.beginTransaction();
		try {
			transaction = session1.beginTransaction();
			 Address tt=(Address)session1.load(Address.class,1);
		        Student po=tt.getStudent();
		        System.out.println(po.getStudentName());
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	*/	
        

	}

}
