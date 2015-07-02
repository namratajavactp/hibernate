package emp;

import hibernate.HibernateUtility;

import org.hibernate.Query;
import org.hibernate.Session;



import java.util.Iterator;
import java.util.List;

public class EmpFetchRecords
{

	public static void main(String[] args) 
	{
		Session session=HibernateUtility.getSession();
		long t1, t2=0;
		
		// Selecting all the records
		System.out.println("Employees details are as follows");
		
		t1=System.currentTimeMillis();
		Query query= session.createQuery("from EmployeePojo");
		
		List l=query.list();
		Iterator itr=l.iterator();
		
		while(itr.hasNext())
		{	
			EmployeePojo e=(EmployeePojo)itr.next();
			System.out.println(e.getEmpid() + ":" + e.getName() + ":" + e.getSalary());
		}	
		
		t2=System.currentTimeMillis();
		System.out.println("Time: " + (t2-t1) +" ms");
		//try{Thread.sleep(500);}catch(Exception e){}
		System.out.println("Employees details after caching-1 are as follows");
		t1=System.currentTimeMillis();
		query= session.createQuery("from EmployeePojo");
		
		l=query.list();
		itr=l.iterator();
		
		while(itr.hasNext())
		{	
			EmployeePojo e=(EmployeePojo)itr.next();
			System.out.println(e.getEmpid() + ":" + e.getName() + ":" + e.getSalary());
		}	
		
		t2=System.currentTimeMillis();
		System.out.println("Time: " + (t2-t1) +" ms");
		
				
		/*
		System.out.println("Employees details after caching-2 are as follows");
		t1=System.currentTimeMillis();
		query= session.createQuery("from EmployeePojo");
		
		l=query.list();
		itr=l.iterator();
		
		while(itr.hasNext())
		{	
			EmployeePojo e=(EmployeePojo)itr.next();
			System.out.println(e.getEmpid() + ":" + e.getName() + ":" + e.getSalary());
		}	
		
		t2=System.currentTimeMillis();
		System.out.println("Time: " + (t2-t1) +" ms");
		//t2=System.currentTimeMillis();
		//System.out.println("Time: " + (t2-t1) +" ms");
		
				
		
		System.out.println("Employees details after caching-2 are as follows");
		t1=System.currentTimeMillis();
		query= session.createQuery("from EmployeePojo");
		
		l=query.list();
		itr=l.iterator();
		
		while(itr.hasNext())
		{	
			EmployeePojo e=(EmployeePojo)itr.next();
			System.out.println(e.getEmpid() + ":" + e.getName() + ":" + e.getSalary());
		}	
		
		t2=System.currentTimeMillis();
		System.out.println("Time: " + (t2-t1) +" ms");
		*/
			}

}
