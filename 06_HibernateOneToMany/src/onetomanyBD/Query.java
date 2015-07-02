/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package onetomanyBD;

import hibernate.HibernateUtility;

import java.util.HashSet;
import java.util.Iterator;
 
import java.util.Set;
 
import onetomanyBD.Address;
import onetomanyBD.Person;

import org.hibernate.Session;
 
 
 

public class Query {
    public static void main(String[] args) {
       
        Session session=HibernateUtility.getSession();
        
       
         Person p=(Person)session.get(Person.class,new Long(1l));
        
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
        
      //Address to person
       /* Address a1=(Address)session.get(Address.class,new Long(201));
        
        Person p=a1.getPerson();
        System.out.println("-----------Person Details: -------------");
        System.out.println("Person Id: " + p.getPersonId());
        System.out.println("Person Name: " + p.getName());
        System.out.println("Person Phone No: " + p.getPhone());
        
        System.out.println();
        System.out.println("------------Person's Address Details are:---------");
      
        System.out.println(a1.getAddressId() + ":" + a1.getDoorNo() + ":" + a1.getStreetName() + ":" + a1.getCity() + ":" + a1.getState());
       
      */
        
    }
                

}
