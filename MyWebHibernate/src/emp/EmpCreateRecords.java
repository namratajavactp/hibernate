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
		Context ctx=new InitialContext();
		 UserTransaction tx=(UserTransaction)ctx.lookup("java:comp/UserTransaction"); 
		 tx.begin(); 
		
		//Transaction tx=session.beginTransaction();
		 EmployeePojo emp1=new EmployeePojo();
		 emp1.setEmpid(102);
		 emp1.setName("shamu");
		 emp1.setSalary(1500);
		 session.save(emp1);

		 EmployeePojo emp11=new EmployeePojo();
		 emp11.setEmpid(103);
		 emp11.setName("nama");
		 emp11.setSalary(2500);
		 session.save(emp11);
		emp11.setSalary(6000);
		
		session.flush();
		tx.commit();
		//tx.commit();
		session.close();
	}catch(Exception e){
		e.printStackTrace();
	}
		 
		 
		 
		 
	}

}
