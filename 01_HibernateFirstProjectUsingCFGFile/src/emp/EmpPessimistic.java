package emp;
// you need sql server for this example (Mysql will not do)
/*Default Transaction isolation level for SQL Server is 'Read commited'
 and not 'repeatable read'.
 Repeatable read isolation eliminates another transaction from updating row data 
 between two consecutive reads of that row data in ongoing transaction
 */

/*
 * Normally read commited isolation level is sufficient for most
 * of the applications.In case you need repeatable read isolation level
 * then instead of keeping/setting entire database isolation level to
 * 'repeatable read' you can get a 'pessimistic upgrade lock' in hibernate
 * which locks the row in database thereby prohibiting another transaction
 * from updating a row in middle of two consecutive reads of row data in
 * ongoing transaction
 */
/*
 * pessimistic upgrade lock internally issues 'select for update query'
 * thereby locking the row in database
 * 
 */
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
			 session.lock(p1, LockMode.UPGRADE);
			System.out.println("inside 2nd thread:1st read of emp name:"+p1.getName());
			System.out.println("before sleeping in 2nd thread");
			
			try
			{
				
			Thread.sleep(7500);
			}
			catch(Exception e)
			{
				
			}
			System.out.println("after waking in 2nd thread");
	      session.evict(p1);
	/*	String name=(String) session.createSQLQuery("select i.ename as fname from EmployeePojo i"+
													" where i.eid=101")
													.addScalar("fname")
													.uniqueResult();
			System.out.println("repeatable read:emp name"+name+" emp name"+p1.getName());
		*/	
		 EmployeePojo p2=(EmployeePojo)session.get(EmployeePojo.class, 101);
				System.out.println("inside 2nd thread:2nd read of emp name:"+p2.getName());
			
			/* see that 1st read and 2nd read value is same.which would not be the
			 * case if you remove pessimistic lock
			 * by commenting line - session.lock(p1, LockMode.UPGRADE);
			 */
			
				
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
