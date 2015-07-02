package emp;

import hibernate.HibernateUtility;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



import java.util.Date;
import java.util.Iterator;
import java.util.List;

class Thread1 implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
	    Session session=HibernateUtility.getSession();
		long t1, t2=0;
		//System.getProperty(arg0, arg1)
		// Selecting all the records
		System.out.println("Employees details are as follows");
		
		t1=System.currentTimeMillis();
		Query query= session.createQuery("from EmployeePojo");
		System.out.println("listing employees after create query");
		List l=query.list();
		System.out.println("iterating list");
		Iterator itr=l.iterator();
		
		while(itr.hasNext())
		{	EmployeePojo p=(EmployeePojo)itr.next();
/*			if(p.getEmpid()==50)
				try {
					System.out.println("sleeping thread1"+new Date());
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			System.out.print(p+" ");
		}	
		t2=System.currentTimeMillis();
		System.out.println("Time: " + (t2-t1) +" ms");
		
		
		  EmployeePojo p=(EmployeePojo) session.load(EmployeePojo.class,51);
		System.out.println(p);
		
		/*	

		try {
			System.out.println("sleeping thread1"+new Date());
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Session ss=HibernateUtility.getSession();
		ss.beginTransaction();  
		
		  EmployeePojo pp=(EmployeePojo) ss.load(EmployeePojo.class,51);
		  System.out.println(pp);
		ss.getTransaction().commit();
		ss.close();  */
		/*
		
		
		String name=(String) session.createSQLQuery("select i.name as fname from emptable i"+
		" where i.empid=51")
		.addScalar("fname")
		.uniqueResult();
System.out.println("repeatable read:emp name"+name+" emp name"+p.getName());

		session.close();

		Session ss=HibernateUtility.getSession();
		ss.beginTransaction();
			
		
		  EmployeePojo pp=(EmployeePojo) ss.load(EmployeePojo.class,51);
		  System.out.println(pp);
		ss.getTransaction().commit();
		ss.close();  */
			
	}
	
}
class Thread2 implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("inside thread2");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("wokeup thread2"+new Date());
		Session s=HibernateUtility.getSession();
		Transaction tx=s.beginTransaction();
		EmployeePojo p=(EmployeePojo)s.load(EmployeePojo.class, 51);
		//p.setEmpid(51);
		p.setSalary(781631);
		p.setName("new name3");
		s.saveOrUpdate(p);
		tx.commit();
		System.out.println("updated");
	}
	
}

public class EmpFetchRecords
{

	public static void main(String[] args) 
	{
		Thread t1=new Thread(new Thread1());
		Thread t2=new Thread(new Thread2());
		t1.start();
		t2.start();
	}

}
