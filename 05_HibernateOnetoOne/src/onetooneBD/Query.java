/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package onetooneBD;

import hibernate.HibernateUtility;

import java.util.HashSet;
import java.util.Iterator;
 
import java.util.Set;
 
import org.hibernate.Session;
 
 
 

public class Query {
    public static void main(String[] args) {
       
        Session session=HibernateUtility.getSession();
        
       // person to address
         Person p=(Person)session.get(Person.class,new Long(1l));
        
        Address a1=(Address)p.getAddress();
        System.out.println("-----------Person Details: -------------");
        System.out.println("Person Id: " + p.getPersonId());
        System.out.println("Person Name: " + p.getName());
        System.out.println("Person Phone No: " + p.getPhone());
        
        System.out.println();
        System.out.println("------------Person's Address Details are:---------");
      
        System.out.println(a1.getAddressId() + ":" + a1.getDoorNo() + ":" + a1.getStreetName() + ":" + a1.getCity() + ":" + a1.getState());
       
        //Address to person
        Address a11=(Address)session.get(Address.class,new Long(1l));
        
        Person p1=a11.getPerson();
        System.out.println("-----------Person Details: -------------");
        System.out.println("Person Id: " + p1.getPersonId());
        System.out.println("Person Name: " + p1.getName());
        System.out.println("Person Phone No: " + p1.getPhone());
        
        System.out.println();
        System.out.println("------------Person's Address Details are:---------");
      
        System.out.println(a1.getAddressId() + ":" + a1.getDoorNo() + ":" + a1.getStreetName() + ":" + a1.getCity() + ":" + a1.getState());
       
        
    }
                

}
