package emp;
 

import javax.persistence.*;



public class EmpCreateRecords {

	
	public static void main(String[] args)
	{
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("empperunit");
		EntityManager e=emf.createEntityManager();
		EntityTransaction tx=e.getTransaction();
		tx.begin();
	
		
		 
		 EmployeePojo emp1=new EmployeePojo();
		 emp1.setEmpid(101);
		 emp1.setName("emp1");
		 emp1.setSalary(1500);
		 e.persist(emp1);
		 tx.commit();
		 e.close();
		 EntityManagerFactory emf1=Persistence.createEntityManagerFactory("empperunit");
			EntityManager e1=emf1.createEntityManager();
			EntityTransaction tx1=e1.getTransaction();
			tx1.begin();
		
                 EmployeePojo p=e1.find(emp.EmployeePojo.class,101);
                 System.out.println(p.getName());
            tx1.commit();
            e1.close();
                          
		 		 
	}

}
