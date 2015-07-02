package NamedSQLQueries;
import hibernate.HibernateUtility;

import java.util.*;

import java.sql.*;
import org.hibernate.*;
import org.hibernate.criterion.*;

public class Main {
		public static void main(String[] args) {
		
		Session session = HibernateUtility.getSession();
		//prepareData(session);
        Query query = session.getNamedQuery("HQLpricing");
       // Query query= session.getNamedQuery("HQLpricing");
        List results = query.list();
         displayObjectList(results);
		
		
    

	}
    static public void displayObjectList(List list)
    {
        Iterator iter = list.iterator();
        if (!iter.hasNext())
        {
            System.out.println("No objects to display.");
            return;
        }
        while (iter.hasNext())
        {
            System.out.println("New object");
            Object obj = (Object) iter.next();
            System.out.println(obj);
            
            
            
        }
    }       


	private static void prepareData(Session session){
      
		Transaction tx=session.beginTransaction();
        Supplier supplier1 = new Supplier();
        supplier1.setName("Supplier Name 1");
        
        
        Supplier supplier2 = new Supplier();
        supplier2.setName("Supplier Name 2");
               
        
        Product product1 = new Product("Product 1","Name for Product 1", 2.0);
        supplier1.getProducts().add(product1);
                
        Product product12 = new Product("Product 2","Name for Product 2", 22.0);
        supplier1.getProducts().add(product12);        
        
        
        Product product2 = new Product("Product 3", "Name for Product 3", 30.0);
       
        supplier2.getProducts().add(product2);
        session.save(supplier1);
        session.save(supplier2);
        System.out.println("Records inserted");
        tx.commit();
        	}
}