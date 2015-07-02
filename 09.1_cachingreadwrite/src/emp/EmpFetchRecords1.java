package emp;

import hibernate.HibernateUtility;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



import java.util.Date;
import java.util.Iterator;
import java.util.List;

class Thread11 implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
	   
	    
	    Session s=HibernateUtility.getSession();
		Transaction tx=s.beginTransaction();
		EmployeePojo p=(EmployeePojo)s.load(EmployeePojo.class, 51);
		System.out.println("loaded"+p);
		//p.setEmpid(51);
		p.setSalary(781631);
		p.setName("new name3");
		s.saveOrUpdate(p);
		tx.commit();
		System.out.println("updated");
		
		}
}
class Thread22 implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("inside thread2");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("wokeup thread2"+new Date());
		Session s=HibernateUtility.getSession();
		Transaction tx=s.beginTransaction();
		EmployeePojo p=(EmployeePojo)s.load(EmployeePojo.class, 51);
		tx.commit();
		System.out.println("emp"+p);
	}
	
}

public class EmpFetchRecords1
{

	public static void main(String[] args) 
	{
		Thread t1=new Thread(new Thread11());
		Thread t2=new Thread(new Thread22());
		t1.start();
		t2.start();
	}

}
