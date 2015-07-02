package emp;
 
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.HibernateUtility;
public class EmpCreateRecords11 {

	
	public static void main(String[] args)
	{	
		
		Session session1=HibernateUtility.getSession();
		Transaction tx1= session1.beginTransaction();
		
		//delete and update the record
		EmployeePojo p1=(EmployeePojo)session1.load(EmployeePojo.class, 102);
		
		p1.setName("nita");
		
		
		tx1.commit();
		session1.close();
		
		System.out.println(p1.getName());
		 
	}  

}
