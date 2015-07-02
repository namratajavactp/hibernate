package keywithanno;
import hibernate.HibernateUtility;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;


public class EmpCreateRecords {

	
	public static void main(String[] args)
	{
		Session session= new AnnotationConfiguration().configure("hibernate-annotation.cfg.xml").buildSessionFactory().openSession();
		//if u dont want to make entry into cfg file...!


	
		Transaction tx=session.beginTransaction();
		 
		 EmployeePojo emp1=new EmployeePojo();
	 
		 emp1.setName("Ramu");
		 emp1.setSalary(1500);
		 session.save(emp1);

		 EmployeePojo emp2=new EmployeePojo();
	 
		 emp2.setName("Rakesh");
		 emp2.setSalary(2500);
		 session.save(emp2);
		 
		 
		 EmployeePojo emp3=new EmployeePojo();
	 
		 emp3.setName("Ravi");
		 emp3.setSalary(3500);
		 
		session.save(emp3);
		emp3.setName("another");
		
		 
		tx.commit();
		 
		 
		 
		 
		 
	}

}
