package emp;

import hibernate.HibernateUtility;


import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmpUpdateDelete {

	public static void main(String[] args) 
	{
		
		Session session=HibernateUtility.getSession();
		Transaction tx= session.beginTransaction();
		
		//delete the record
		EmployeePojo p1=(EmployeePojo)session.load(EmployeePojo.class, 101);
		session.delete(p1);
		tx.commit();
		session.close();
		
		
		Session session1=HibernateUtility.getSession();
		Transaction tx1= session1.beginTransaction();
		EmployeePojo p2=(EmployeePojo)session1.load(EmployeePojo.class, 103);
		         
		System.out.println(p2.getName());	
		p2.setName("namrata");
		tx1.commit();
		session1.close(); 
		//Query query= session.createQuery("update EmployeePojo e set e.salary=7000 where e.empid=101 ");
		//int rows=query.executeUpdate();
		//delete the record
	
	
		// Deleting Records
		/*Query query= session.createQuery("delete from EmployeePojo");
		int rows=query.executeUpdate();
		
		*/
		
			
		
	}
}
