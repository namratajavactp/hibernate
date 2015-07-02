package lazydemo;

import hibernate.HibernateUtility;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;

public class Query {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Long t1= System.currentTimeMillis();
		Session session= HibernateUtility.getSession();
		Person p=(Person)session.load(Person.class,new Long(2l));
		 session.close();
		 
		System.out.println("-----------Person Details: -------------");
        System.out.println("Person Id: " + p.getPersonId());
        System.out.println("Person Name: " + p.getName());
        System.out.println("Person Phone No: " + p.getPhone());
        
		Set<Address> a1=(Set)p.getAddresses();
        
        System.out.println();
        System.out.println("------------Person's Address Details are:---------");
        Iterator<Address> itr= a1.iterator();
        while(itr.hasNext())
        {
        	Address ad=itr.next();
        	System.out.println(ad.getAddressId() + ":" + ad.getDoorNo() + ":" + ad.getStreetName() + ":" + ad.getCity() + ":" + ad.getState());
        }
        /*
         p=(Person)session.get(Person.class,new Long(1l));
        //getting the address on person
         System.out.println("-----------Person Details: -------------");
         System.out.println("Person Id: " + p.getPersonId());
         System.out.println("Person Name: " + p.getName());
         System.out.println("Person Phone No: " + p.getPhone());
         
         System.out.println();
         
         
        a1=(Set)p.getAddresses();
        System.out.println("------------Person's Address Details are:---------");
        itr= a1.iterator();
        while(itr.hasNext())
        {
        	Address ad=itr.next();
        	System.out.println(ad.getAddressId() + ":" + ad.getDoorNo() + ":" + ad.getStreetName() + ":" + ad.getCity() + ":" + ad.getState());
        }
        
        Long t2=System.currentTimeMillis();
        
        System.out.println("Time taken is: " + (t2-t1) + "ms");
        */
        
        
       
     
	}

}
