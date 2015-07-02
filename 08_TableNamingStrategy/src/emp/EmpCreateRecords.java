package emp;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.HibernateUtility;
public class EmpCreateRecords {

	
	public static void main(String[] args)
	{
		Session session=HibernateUtility.getSession();
		//session.setFlushMode(FlushMode.NEVER);
		Transaction tx=session.beginTransaction();
		 
		 EmployeePojo emp1=new EmployeePojo();
		 emp1.setEmpid(104);
		 emp1.setName("Ramu");
		 emp1.setSalary(1500);
		 session.save(emp1);

		 EmployeePojo emp2=new EmployeePojo();
		 emp2.setEmpid(105);
		 emp2.setName("Ramu111");
		 emp2.setSalary(2500);
		 session.save(emp2);
		 
		 EmployeePojo emp3=new EmployeePojo();
		 emp3.setEmpid(106);
		 emp3.setName("Raghu");
		 emp3.setSalary(29);
		 session.save(emp3);
		 
		
		//session.flush();
		
		//session.clear();
		/*EmployeePojo p1=(EmployeePojo)session.load(EmployeePojo.class, 103);
		System.out.println(p1.getName());*/
		
		tx.commit();
		 
		 
		 
		 
		 
	}

}
