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
		
		 
		Query query= session.createQuery("from EmployeePojo");
		List l=query.list();
		System.out.println("Employees details are as follows");
		Iterator itr=l.iterator();
		while(itr.hasNext())
		{	
			EmployeePojo e=(EmployeePojo)itr.next();
			System.out.println(e.getEmpid() + ":" + e.getYear() + ":" + e.getMonth() + ":" + e.getSalary());
		}	
		
		 
	}

}
