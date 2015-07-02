package emp;

import hibernate.HibernateUtility;

import org.hibernate.FlushMode;
import org.hibernate.Session;

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
			System.out.println("inside 1st thread"+p1.getName()+" get sal:"+p1.getSalary());
			
			try{
				Thread.sleep(3000);
			}
			catch(Exception e){}
			
		//if these lines are uncommented you will get StaleObjectException
		//	p1.setName("jaya");
		//	p1.setSalary(1000);
			
		//otherwise dirty checking proves that no modfication is done hence database
		//is not contacted and hence no stale object exceptio is thrown
			session.flush();
			System.out.println("1st thread after wake up:"+p1.getSalary());
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
			
			session.beginTransaction();
			session.update(p1);
			session.getTransaction().commit();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session=HibernateUtility.getSession();
		new FirstThread(session).start();
		new SecondThread(session).start();
	}

}
