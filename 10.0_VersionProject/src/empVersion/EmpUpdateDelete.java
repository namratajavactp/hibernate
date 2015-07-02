package empVersion;

import hibernate.HibernateUtility;

import org.hibernate.LockMode;
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
		session.close();
		*/
		
		//Updating Records
		
		Query query= session.createQuery("update EmployeePojo e set e.salary=102000 where e.empid=102 ");
		int rows=query.executeUpdate();
		EmployeePojo pojo=(EmployeePojo) session.get(EmployeePojo.class, 102);
		session.lock(pojo, LockMode.FORCE);
		
		session.save(pojo);
		
		tx.commit();
		session.close();
			
		
	}
}
