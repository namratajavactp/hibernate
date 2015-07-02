/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package onetomanyBD;

import hibernate.HibernateUtility;


import java.util.*;
import java.util.logging.Logger;

import onetomanyBD.Address;
import onetomanyBD.Person;

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
        
        
        Address ad2=new Address();
        ad2.setAddressId(202);
        ad2.setDoorNo(501);
        ad2.setStreetName("Khandeveli");
        ad2.setCity("Mumbai");
        ad2.setState("Maharashtra");
        Set<Address> addresses1= new HashSet<Address>();
     
        addresses1.add(ad1);
        addresses1.add(ad2);
        Person p1=new Person();
        p1.setPersonId(1L);
        p1.setName("Ram");
        p1.setPhone(123123312L);
        p1.setAddresses(addresses1);
         ad1.setPerson(p1);
         ad2.setPerson(p1);
        Session session=HibernateUtility.getSession();
        
        Transaction t=session.beginTransaction();
       
        session.save(p1);
       
        
       
         t.commit();
         session.close();
         
        /* 
         Session session1=HibernateUtility.getSession();
         
         Transaction t1=session1.beginTransaction();
        
         
         Address tt=(Address)session1.load(onetomanyBD.Address.class,201L);
            Person po=tt.getPerson();
            System.out.println(po.getName());
        
            Person p=(Person)session1.load(onetomanyBD.Person.class,1L);
            Set<Address> s = p.getAddresses();
            
            Iterator i=s.iterator();
            while(i.hasNext())
            {
            	Address ob=(Address)i.next();
            	 System.out.println(ob.getCity());
            	
            }
           
        
          t1.commit();
          session1.close();
         */
         
        }catch(Exception e){
            e.printStackTrace();
        }    
    }
                

}
