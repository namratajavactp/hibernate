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
		//Query query= session.createQuery("from EmployeePojo");
		/*List l=query.list();
		System.out.println("Employees details are as follows");
		for(Object o:l) {
			System.out.println(o);
		}	*/
		 
		Query query= session.createQuery("from EmployeePojo");
		List l=query.list();
		System.out.println("Employees details are as follows");
		Iterator itr=l.iterator();
		while(itr.hasNext())
		{	
			EmployeePojo e=(EmployeePojo)itr.next();
			System.out.println(e.getEmpid() + ":" + e.getName() + ":" + e.getSalary());
		}	
		
	/*
		//Fetching only few columns
		
		Query query1= session.createQuery("select emp1.empid, emp1.name from EmployeePojo emp1");
		List l1=query1.list();
		Iterator itr1=l1.iterator();
		System.out.println("-----------  Employees are:---------- ");
		
		
		while(itr1.hasNext())
		{	
			Object o[]=(Object[]) itr1.next();
		
			System.out.println(o[0]+" " +o[1]);
		}	
		
		*/
		//Fetching few records based on conditions
		
		/*Query query2= session.createQuery("from EmployeePojo emp2 where emp2.salary>2000");
		List l2=query2.list();
		System.out.println("***************** Employees details are as follows ************ ");
		Iterator itr2=l2.iterator();
		while(itr2.hasNext())
		{	
			EmployeePojo e2=(EmployeePojo)itr2.next();
			System.out.println(e2.getEmpid() + ":" + e2.getName() + ":" + e2.getSalary() );
		}
	}*/

	}}
