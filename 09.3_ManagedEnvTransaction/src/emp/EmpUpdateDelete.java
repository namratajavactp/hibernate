package emp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.transaction.UserTransaction;

import hibernate.HibernateUtility;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmpUpdateDelete {

	//public static void main(String[] args)
	public void updateDelete()
	{
		try{
		Session session=HibernateUtility.getSession();
		Context ctx=new InitialContext();
		
		 UserTransaction tx=(UserTransaction)ctx.lookup("java:comp/UserTransaction");
		 tx.begin();
		
		EmployeePojo p=new EmployeePojo();
		p.setEmpid(103);
		p.setName("askf");
		p.setSalary(17001);
		session.merge(p);
		session.evict(p);
		
		tx.commit();
		
		session.close();
		}catch(Exception e){e.printStackTrace();}
		
	}
}
