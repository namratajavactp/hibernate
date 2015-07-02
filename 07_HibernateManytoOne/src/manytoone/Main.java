/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manytoone;

import hibernate.HibernateUtility;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        try{
        
        	// Address entity    
        Address ad1=new Address();
        ad1.setAddressId(201);
        ad1.setDoorNo(101);
        ad1.setStreetName("MG Road");
        ad1.setCity("Bangalore");
        ad1.setState("Karnataka");
        
        
        
        Person p1=new Person();
        p1.setPersonId(1L);
        p1.setName("Ram");
        p1.setPhone(123123312L);
        p1.setAddress(ad1);
        
        
        Person p2=new Person();
        p2.setPersonId(2L);
        p2.setName("Raju");
        p2.setPhone(3435345456l);
        p2.setAddress(ad1);
        
        //opening session and starting transaction
        Session session=HibernateUtility.getSession();
        
        Transaction t=session.beginTransaction();
        //persisting person              
        session.save(ad1);
        session.save(p1);
        session.save(p2);
        //closing transaction
         t.commit();
         
         //searching person on id
        Person p=(Person)session.get(Person.class,new Long(1l));
        Person p3=(Person)session.get(Person.class,new Long(2l));
        //getting the address on person
        
        System.out.println("-----------Person Details: -------------");
        System.out.println("Person Id: " + p.getPersonId());
        System.out.println("Person Name: " + p.getName());
        System.out.println("Person Phone No: " + p.getPhone());
        
        System.out.println();
        System.out.println("------------Person's Address Details :---------");
        	Address ad=p.getAddress();
        	System.out.println(ad.getAddressId() + ":" + ad.getDoorNo() + ":" + ad.getStreetName() + ":" + ad.getCity() + ":" + ad.getState());
        
        
        	System.out.println("-----------Person Details: -------------");
            System.out.println("Person Id: " + p3.getPersonId());
            System.out.println("Person Name: " + p3.getName());
            System.out.println("Person Phone No: " + p3.getPhone());
            
            System.out.println();
            System.out.println("------------Person's Address Details :---------");
            	ad=p.getAddress();
            	System.out.println(ad.getAddressId() + ":" + ad.getDoorNo() + ":" + ad.getStreetName() + ":" + ad.getCity() + ":" + ad.getState());
            
                    
        session.close();
        }catch(Exception e){
            e.printStackTrace();
        }    
    }
                

}
