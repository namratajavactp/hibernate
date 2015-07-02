/*
 * 
 * 
 * 
 */
package emp;
 
import java.util.Iterator;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.HibernateUtility;
public class EmpCreateRecords {

	
	public static void main(String[] args)
	{
		Session session=HibernateUtility.getSession();
	
		Transaction tx=session.beginTransaction();
		 
		 EmployeePojo emp1=new EmployeePojo();
		 emp1.setEmpid(101);
		 emp1.setName("emp1");
		 emp1.setSalary(1500);
		 session.save(emp1);

		 EmployeePojo emp2=new EmployeePojo();
		 emp2.setEmpid(102);
		 emp2.setName("emp2");
		 emp2.setSalary(2500);
		 session.save(emp2);
		 
		 
		 EmployeePojo emp3=new EmployeePojo();
		 emp3.setEmpid(103);
		 emp3.setName("emp3");
		 emp3.setSalary(3500);
	
		 
		session.save(emp3);
		
		emp3.setSalary(30000);
	
		tx.commit();
		session.close(); 
	/*
		
//load and query		
		Session session2=HibernateUtility.getSession();

		Query query= session2.createQuery("from EmployeePojo");
		List l=query.list();
		System.out.println("Employees details are as follows");
		Iterator itr=l.iterator();
		while(itr.hasNext())
		{	
			EmployeePojo e=(EmployeePojo)itr.next();
			System.out.println(e.getEmpid() + ":" + e.getName() + ":" + e.getSalary());
		}	
		 */
//load,delete,upadte
		/*
		Session session1=HibernateUtility.getSession();
		Transaction tx1= session1.beginTransaction();
		
		//delete and update the record
		EmployeePojo p1=(EmployeePojo)session1.load(EmployeePojo.class, 101);
		System.out.println(p1.getName());
		session1.delete(p1);
		
		EmployeePojo p2=(EmployeePojo)session1.load(EmployeePojo.class, 102);
		System.out.println(p2.getName());
		p2.setName("namrata");
	//	session1.update(p2);
		
		tx1.commit();
		session1.close();
		*/
		
		 
	}  

}
