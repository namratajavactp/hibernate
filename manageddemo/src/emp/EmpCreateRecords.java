package emp;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.transaction.UserTransaction;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.HibernateUtility;
public class EmpCreateRecords {

	
	//public static void main(String[] args)
	public void create()
	{try{
		Session session=HibernateUtility.getSession();
		//Context ctx=new InitialContext();
		 /*UserTransaction tx=(UserTransaction)ctx.lookup("java:comp/UserTransaction");
		 tx.begin();
		*/
		session.beginTransaction();
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
		
		session.getTransaction().commit();
		//tx.commit();
	}catch(Exception e){
		e.printStackTrace();
	}
		 
		 
		 
		 
	}

}
