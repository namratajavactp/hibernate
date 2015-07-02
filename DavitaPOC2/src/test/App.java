package test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App {
	 
    public static void main( String[] args )
    {
    	  App a=new App();
       // a.insertdata();
        a.fetch();
        System.out.println("Great! Students were saved");

    }
    
    /* code to fetch data inside multiple tables using many to many relationship
     */
    
    public void fetch()
	   {
		   Session session = HibernateUtil.getSessionFactory().openSession();
		   String hql = "FROM Program_Years ";//WHERE E.id = :employee_id
		   Query query = session.createQuery(hql);
		   //query.setParameter("employee_id",10);
		   List<Program_Years> results = query.list();
		   
		   for (Iterator iterator = 
			   results.iterator(); iterator.hasNext();){
			   
			   Program_Years programYears = (Program_Years) iterator.next(); 
			   Set<Periods_for_program_and_year> set=programYears.getPeriods_for_program_and_year();
	            
	            for(Periods_for_program_and_year obj:programYears.getPeriods_for_program_and_year())
	            {
	              	System.out.println("-----");
	              	
	            	Program_Years py=obj.getProgramcd();
	            	System.out.println("Program Name: " + py.getProgram_name()); 
	            	
	            	Period_Types pt=obj.getPeriodtypecd();
	            	System.out.println("period type: " + pt.getPeriod_type()); 
	            	
	            	System.out.println("Year: " + obj.getYear()); 
	            	
	            	System.out.println("-----");
	            	
	           }
	       
		   }
	       
	   }
    
    /* code to insert data inside multiple tables using many to many relationship
     */
    
    public void insertdata()
    {
    	 Session session = HibernateUtil.getSessionFactory().openSession();

         session.beginTransaction();

         Program_Years student1 = new Program_Years("4","21");

         Period_Types class1 = new Period_Types("5","Spring");
         session.save(class1);      

         Periods_for_program_and_year studentClass = new Periods_for_program_and_year();

         studentClass.setProgramcd(student1);
         studentClass.setPeriodtypecd(class1);

        
         studentClass.setYear("2011"); // The new date column

         student1.getPeriods_for_program_and_year().add(studentClass);

         session.save(student1);      

         session.getTransaction().commit();
    }
    
}
