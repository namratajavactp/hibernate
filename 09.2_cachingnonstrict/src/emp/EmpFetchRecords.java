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
		
		// Selecting all the records
		System.out.println("Employees details are as follows");
		
		t1=System.currentTimeMillis();
		Query query= session.createQuery("from EmployeePojo");
		
		List l=query.list();
		Iterator itr=l.iterator();
		
		while(itr.hasNext())
		{	EmployeePojo p=(EmployeePojo)itr.next();
			if(p.getEmpid()==50)
				try {
					Thread.sleep(200);
					System.out.println("wokeup thread1");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.print(p+" ");
			 
		}	
		t2=System.currentTimeMillis();
		System.out.println("Time: " + (t2-t1) +" ms");
	
		/*	EmployeePojo p=(EmployeePojo) session.load(EmployeePojo.class,51);
		System.out.println(p);
		
		
		
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
		ss.close(); */ 
		
		/*
		
		String name=(String) session.createSQLQuery("select i.name as fname from emptable i"+
		" where i.empid=51")
		.addScalar("fname")
		.uniqueResult();
System.out.println("repeatable read:emp name"+name+" emp name"+p.getName());

		session.close();

		Session ss=HibernateUtility.getSession();
		ss.beginTransaction();  */
		/*EmployeePojo p =(EmployeePojo) ss.createQuery("from EmployeePojo e where e.empid = :id").setString("id","51").uniqueResult();
		
				System.out.println(p); */
		
		/*
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
			Thread.sleep(1000);
			System.out.println("wokeup thread2");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Session s=HibernateUtility.getSession();
		Transaction tx=s.beginTransaction();
		EmployeePojo p=(EmployeePojo)s.load(EmployeePojo.class, 51);
		//p.setEmpid(51);
		p.setSalary(10223);
		p.setName("new name2");
		s.saveOrUpdate(p);
		tx.commit();
		System.out.println("\nupdated");
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
