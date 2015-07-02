
package criteria;

import org.hibernate.*;
import org.hibernate.criterion.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import hibernate.HibernateUtility;

import java.util.*;


public class AggregateFunctions{
	public static void main(String[] args) {
		Session session = null;

		try{
			 session =HibernateUtility.getSession();
			 	System.out.println("Fetching Record");
				Contact contact;
				System.out.println("before creating");
                Criteria c = session.createCriteria(criteria.Contact.class);
               // c.setFirstResult(2);  // 3rd row will be first record
                //c.setMaxResults(2);
                
                
              
              
                ProjectionList pl=Projections.projectionList();
                pl.add(Projections.rowCount());
                pl.add(Projections.sum("id"));
                pl.add(Projections.avg("id"));
                pl.add(Projections.max("id"));
                pl.add(Projections.min("id"));
                c.setProjection(pl); 
                
               
               	
                List l2= c.list();
                Object[] lists= (Object[])l2.get(0);
                
                for(int i=0; i< lists.length; i++)
                {
                	System.out.print("here is the value"+lists[i]+ ":");
                }         	
               	
                    System.out.println("Done");
		}catch(Exception e){
			//tx.rollback();
			System.out.println(e.getMessage());
		}finally{
			// Actual contact insertion will happen at this step
			//session.save();
			session.close();

			}
		
	}
}
