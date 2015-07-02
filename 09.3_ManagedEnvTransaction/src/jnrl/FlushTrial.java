package jnrl;

import hibernate.HibernateUtility;
import emp.*;


import org.hibernate.FlushMode;
import org.hibernate.*;

public class FlushTrial {

	/**
	 * @param args
	 */
	static class FirstThread extends Thread
	{
		private Session session;
		
		public void run()
		{
			
			session.setFlushMode(FlushMode.COMMIT);
			EmployeePojo p1=(EmployeePojo)session.load(EmployeePojo.class, 101);
			//System.out.println(p1.getName());
			try{
				Thread.sleep(3000);
			}
			catch(Exception e){}
			session.flush();
			System.out.println(p1.getSalary());
		}

		public FirstThread(Session session) {
			super();
			this.session = session;
		}
	}
	static class SecondThread extends Thread
	{
		private Session session;
		public SecondThread(Session session) {
			super();
			this.session = session;
		}
		public void run()
		{
			try{
			Thread.sleep(1000);
		}catch(Exception e){}
			Session session=HibernateUtility.getSession();
			EmployeePojo p1=new EmployeePojo();
			p1.setEmpid(101);
			p1.setName("Raju1");
			p1.setSalary(133);
			
			Transaction tx=session.beginTransaction();
			session.update(p1);
			tx.commit();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session=HibernateUtility.getSession();
		new FirstThread(session).start();
		new SecondThread(session).start();
	}

}
