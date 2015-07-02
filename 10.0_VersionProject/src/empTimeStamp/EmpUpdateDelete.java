package empTimeStamp;

import hibernate.HibernateUtility;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmpUpdateDelete {

	public static void main(String[] args) 
	{
		
		Session session=HibernateUtility.getSession();
/*		Transaction tx= session.beginTransaction();
		
		
		
		Query query= session.createQuery("update EmployeePojo e set e.salary=7000 where e.empid=101 ");
		int rows=query.executeUpdate();
		EmployeePojo pojo=(EmployeePojo) session.get(EmployeePojo.class, 101);

		session.lock(pojo, LockMode.FORCE);

		tx.commit();   */
		
	
Transaction tx2= session.beginTransaction();
		
		
		Query query1= session.createQuery("update EmployeePojo e set e.salary=11000 where e.empid=101 ");
		int rows1=query1.executeUpdate();
		EmployeePojo pojo1=(EmployeePojo) session.get(EmployeePojo.class, 101);

		//session.lock(pojo1, LockMode.FORCE);

		tx2.commit();
		
		//System.out.println(tx.wasCommitted());
		session.close();
			
		
	}
}
