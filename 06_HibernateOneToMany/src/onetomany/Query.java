/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package onetomany;

import hibernate.HibernateUtility;

import java.util.HashSet;
import java.util.Iterator;
 
import java.util.Set;
 
import org.hibernate.Session;
 
 
 

public class Query {
    public static void main(String[] args) {
       
        Session session=HibernateUtility.getSession();
        
       
         Person p=(Person)session.load(Person.class,new Long(3l));
        
        Set<Address> a1=(Set)p.getAddresses();
        System.out.println("-----------Person Details: -------------");
        System.out.println("Person Id: " + p.getPersonId());
        System.out.println("Person Name: " + p.getName());
        System.out.println("Person Phone No: " + p.getPhone());
        
        System.out.println();
        System.out.println("------------Person's Address Details are:---------");
        Iterator<Address> itr= a1.iterator();
        while(itr.hasNext())
        {
        	Address ad=itr.next();
        	System.out.println(ad.getAddressId() + ":" + ad.getDoorNo() + ":" + ad.getStreetName() + ":" + ad.getCity() + ":" + ad.getState());
        }
        
 /*Person p2=(Person)session.get(Person.class,new Long(3l));
        
        Set<Address> a2=(Set)p2.getAddresses();
        System.out.println("-----------Person2 Details: -------------");
        System.out.println("Person Id: " + p2.getPersonId());
        System.out.println("Person Name: " + p2.getName());
        System.out.println("Person Phone No: " + p2.getPhone());
        
        System.out.println();
        System.out.println("------------Person's 2 Address Details are:---------");
        Iterator<Address> itr1= a2.iterator();
        while(itr1.hasNext())
        {
        	Address ad2=itr1.next();
        	System.out.println(ad2.getAddressId() + ":" + ad2.getDoorNo() + ":" + ad2.getStreetName() + ":" + ad2.getCity() + ":" + ad2.getState());
        }
 Person p3=(Person)session.load(Person.class,new Long(1l));
        
        Set<Address> a3=(Set)p2.getAddresses();
        System.out.println("-----------Person2 Details: -------------");
        System.out.println("Person Id: " + p3.getPersonId());
        System.out.println("Person Name: " + p3.getName());
        System.out.println("Person Phone No: " + p3.getPhone());
        
        System.out.println();
        System.out.println("------------Person's 2 Address Details are:---------");
        Iterator<Address> itr2= a3.iterator();
        while(itr2.hasNext())
        {
        	Address ad3=itr2.next();
        	System.out.println(ad3.getAddressId() + ":" + ad3.getDoorNo() + ":" + ad3.getStreetName() + ":" + ad3.getCity() + ":" + ad3.getState());
        }*/
      
        
    }
                

}
