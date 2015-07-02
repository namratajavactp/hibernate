package emp;
import org.hibernate.FlushMode;
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
		 emp1.setName("Ramu");
		 emp1.setSalary(1500);
		 session.save(emp1);
		 
		 

		 EmployeePojo emp2=new EmployeePojo();
		 emp2.setEmpid(102);
		 emp2.setName("Rakesh");
		 emp2.setSalary(2500);
		 session.save(emp2);
		 
		 
		 EmployeePojo emp3=new EmployeePojo();
		 emp3.setEmpid(103);
		 emp3.setName("Ravi");
		 emp3.setSalary(3500);
		 
		session.save(emp3);
		emp3.setName("another");
		
		
		
		tx.commit();
		
		System.out.println(((EmployeePojo)session.get(EmployeePojo.class, 103)).getName());
		session.close();
		 
		 
		 
		 
	}

}
