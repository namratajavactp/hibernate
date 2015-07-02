package emp;

/*

Item item = ... ;
Bid bid = new Bid();
item.addBid(bid);
...
Transaction tx = session.beginTransaction();
session.lock(item, LockMode.READ);
tx.commit();
 
 */

import hibernate.HibernateUtility;


import org.hibernate.*;

public class EmpLockingRead {

	/**
	 * @param args
	 */
	static class FirstThread extends Thread
	{
		private Session session;
		
		public void run()
		{
			 
			 Transaction t=session.beginTransaction();

			EmployeePojo p1=(EmployeePojo)session.get(EmployeePojo.class, 101);
			System.out.println("inside 1st thread"+p1.getName()+" get sal:"+p1.getSalary());
			
			t.commit();
			
			session.close();
			
			try
			{
			Thread.sleep(2000);
			}
			catch(Exception e)
			{
				
			}
			
			p1.setName("meena1");
			Session s=HibernateUtility.getSession();
			Transaction tt=s.beginTransaction();
			System.out.println("1ST THREAD UPDATE");
			s.update(p1);
			tt.commit();
			s.close();
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
			 
			System.out.println("inside 2nd thread"+p1.getName()+" get sal:"+p1.getSalary());
				
			t.commit();
			session.close();
		//	p1.setName("tina");
			try
			{
			  Thread.sleep(5000);
			  
			}
			catch(Exception e)
			{
			  e.printStackTrace(); 	
			}
			Session session1=HibernateUtility.getSession();
			
			Transaction tt=session1.beginTransaction();
			
			System.out.println("2ND THREAD UPDATE");
			session1.lock(p1, LockMode.READ);
			
		   session1.update(p1);
			tt.commit();
			session1.close();
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session=HibernateUtility.getSession();
		new FirstThread(session).start();
		new SecondThread().start();
	}

}
