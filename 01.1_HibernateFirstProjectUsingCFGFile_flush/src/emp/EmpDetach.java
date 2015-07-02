package emp;
import org.hibernate.*;
import hibernate.HibernateUtility;

public class EmpDetach {
	
	public static void main(String[] args)
	{
		Session s=HibernateUtility.getSession();
		Transaction t= s.beginTransaction();
		EmployeePojo e=(EmployeePojo)s.load(EmployeePojo.class,103);
		System.out.println(e.getName());
		e.setName("vvv");
		t.commit();
		s.close();
		
		//e is now a detached object
		
		e.setName("Namrata");
		
		Session s1=HibernateUtility.getSession();
		Transaction t1=s1.beginTransaction();
	//	EmployeePojo e1=(EmployeePojo)s1.get(EmployeePojo.class,103);
	//	System.out.println(e1.getName());
		s1.update(e);
		t1.commit();
		s1.close();
		
		
		
	}

}
