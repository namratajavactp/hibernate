package emp;
 
import java.util.Iterator;
import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import hibernate.HibernateUtility;
public class QueryEx 
{

	
	public static void main(String[] args)throws Exception
	{
		Session session=HibernateUtility.getSession();
		Criteria c=session.createCriteria(EmployeePojo.class);
	//	c.setFirstResult(1);
	//  c.setMaxResults(2);
		c.addOrder(Order.desc("salary"));
		
	    c.add(Restrictions.between("salary",1000d,2700d));
		
		
		List l=c.list();
		
		Iterator i=l.iterator();
		while(i.hasNext())
		{
			EmployeePojo p=(EmployeePojo)i.next();

			System.out.print("\t"+p.getEmpid());
			System.out.print("\t"+p.getName());
			System.out.println("\t"+p.getSalary());
			
		}
		
		c.setProjection(Projections.rowCount());
		List ll= c.list();
       	System.out.println(ll.get(0));
		session.close();
	}
}