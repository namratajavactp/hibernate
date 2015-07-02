package emp;

import hibernate.HibernateUtility;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmpUpdateDelete {

	public static void main(String[] args) 
	{
		
		Session session=HibernateUtility.getSession();
		Transaction tx= session.beginTransaction();
		
		// Deleting Records
		/*Query query= session.createQuery("delete from EmployeePojo");
		int rows=query.executeUpdate();
		tx.commit();
		session.close();*/
		
		
		//Updating Records
		
		EmployeePojo p=new EmployeePojo();
		p.setEmpid(103);
		p.setName("askf");
		p.setSalary(17001);
		session.merge(p);
		session.evict(p);
		//Query query= session.createQuery("update EmployeePojo e set e.salary=7000 where e.empid=101 ");
		//int rows=query.executeUpdate();
		tx.commit();
		
		session.close();
			
		
	}
}
