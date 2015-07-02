package emp;
import org.hibernate.*;
import hibernate.HibernateUtility;

public class EmpDetach1 {
	
	public static void main(String[] args)
	{
		Session s=HibernateUtility.getSession();
		Transaction t=s.beginTransaction();
		EmployeePojo e=(EmployeePojo)s.load(EmployeePojo.class,103);
		System.out.println(e.getName());
		t.commit();
		s.close();
		
		//e is now a detached object
		
		e.setName("Namrata1");
		
		Session s1=HibernateUtility.getSession();
		Transaction t1=s1.beginTransaction();
		EmployeePojo e1=(EmployeePojo)s1.get(EmployeePojo.class,103);
		System.out.println(e1.getName());
		//gives NonUniqueObjectException-a persistent instance with the same db id is
		//already associated with the session.use merge instead of update
		s1.update(e);
		t1.commit();
		s1.close();
		
		
		
	}

}
