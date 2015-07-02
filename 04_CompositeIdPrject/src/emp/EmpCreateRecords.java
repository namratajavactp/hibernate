package emp;
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
		 emp1.setYear(2008);
		 emp1.setSalary(24578);
		 emp1.setMonth("Jan");
		 session.save(emp1);

		 EmployeePojo emp2=new EmployeePojo();
		 emp2.setEmpid(102);
		 emp2.setYear(2008);
		 emp2.setSalary(24578);
		 emp2.setMonth("Jan");
		 session.save(emp2);

		 
		 EmployeePojo emp3=new EmployeePojo();
		 emp3.setEmpid(103);
		 emp3.setYear(2008);
		 emp3.setSalary(24578);
		 emp3.setMonth("Jan");
		 session.save(emp3);
		 
 

		 EmployeePojo emp4=new EmployeePojo();
		 emp4.setEmpid(103);
		 emp4.setYear(2009);
		 emp4.setSalary(24578);
		 emp4.setMonth("Jan");
		 session.save(emp4);

		 tx.commit();
		 
		 
		 
		 
		 
	}

}
