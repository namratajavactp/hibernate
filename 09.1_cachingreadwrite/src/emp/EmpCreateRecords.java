package emp;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.HibernateUtility;
public class EmpCreateRecords {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Session session=HibernateUtility.getSession();
		
		 for(int i=1; i<=100; i++)
		 {	 
			 Transaction tx=session.beginTransaction(); 
			 EmployeePojo emp1=new EmployeePojo();
			 emp1.setEmpid(i);
			 emp1.setName("Ramu" + i);
			 emp1.setSalary(1500 +i);
			 session.save(emp1);
			 tx.commit();
			 emp1=null;
			
		 }	 

				 
	}

}
