package emp;

//you should get StaleObjectStateException (OptimisticLocking)
//always rely on read commited guarantees from database
//Automatic versioning in Hibernate prevents lost updates when two concurrent transactions try to 
//commit modifications on the same piece of data

import hibernate.HibernateUtility;


import org.hibernate.*;

public class EmpPessimistic {

	/**
	 * @param args
	 */
	static class FirstThread extends Thread
	{
		private Session session;
		
		public void run()
		{
			System.out.println("inside 1st thread");
			System.out.println("before sleeping");
			try
			{
			Thread.sleep(2000);
			}
			catch(Exception e)
			{
				
			}
			
			 System.out.println("after waking");
			 Transaction t=session.beginTransaction();

			EmployeePojo p1=(EmployeePojo)session.get(EmployeePojo.class, 101);
			System.out.println("inside 1st thread after retrieveing entity 101"+p1.getName());
			p1.setName("Sitajjj");
			System.out.println("inside 1st thread"+p1.getName()+" get sal:"+p1.getSalary());
			session.save(p1);
		//	session.flush();
		//	session.evict(p1);
		//	EmployeePojo pp=(EmployeePojo)session.get(EmployeePojo.class, 101);
		//	System.out.println("after eviction from 1st thread"+ pp.getName()); 
			t.commit();
			
			session.close();
			
		
			
			
			
			
			}
		
		public FirstThread(Session session) {
			super();
			this.session = session;
		}
	}
	static class SecondThread extends Thread
	{
		SecondThread()
		{
			super();
			
		}
		
		
		public void run()
		{
			Session session=HibernateUtility.getSession();
			 Transaction t=session.beginTransaction();
			 EmployeePojo p1=(EmployeePojo)session.get(EmployeePojo.class, 101);
			// session.lock(p1, LockMode.UPGRADE);
			System.out.println("inside 2nd thread:1st read of emp name:"+p1.getName());
			System.out.println("before sleeping in 2nd thread");
			
			try
			{
				
			Thread.sleep(5500);
			}
			catch(Exception e)
			{
				
			}
			System.out.println("after waking in 2nd thread");
		 // session.evict(p1);
			String name=(String) session.createSQLQuery("select i.name as fname from EmployeePojo i"+
													" where i.empid=101")
													.addScalar("fname")
													.uniqueResult();
			System.out.println("repeatable read:emp name"+name+" emp name"+p1.getName());
			
			
			
				
			t.commit();
			session.close();
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session=HibernateUtility.getSession();
		
		new SecondThread().start();
		
		new FirstThread(session).start();
	}

}
