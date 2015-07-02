/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package setbidirectional;

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
        
        Address ad2=new Address();
        ad2.setAddressId(202);
        ad2.setDoorNo(501);
        ad2.setStreetName("Khandeveli");
        ad2.setCity("Mumbai");
        ad2.setState("Maharashtra");
        
        Set<Address> addresses1= new HashSet<Address>();
        addresses1.add(ad1);
        addresses1.add(ad2);
        //person entity
        Person p1=new Person();
        p1.setPersonId(1L);
        p1.setName("Ram");
        p1.setPhone(123123312L);
        p1.setAddresses(addresses1);
     
        ad1.setPerson(p1);
        ad2.setPerson(p1);
        Session session=HibernateUtility.getSession();
        
        Transaction t=session.beginTransaction();
        //persisting person              
        session.save(p1);
     
        //closing transaction
         t.commit();
        
         Address a1=(Address)session.get(Address.class, 201L);
         System.out.println(a1.getPerson().getName());
   
         //searching person on id
        /*Person p=(Person)session.get(Person.class,new Long(1l));
        //getting the address on person
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
        
         p=(Person)session.get(Person.class,new Long(2l));
        //getting the address on person
        a1=(Set)p.getAddresses();
        System.out.println("-----------Person Details: -------------");
        System.out.println("Person Id: " + p.getPersonId());
        System.out.println("Person Name: " + p.getName());
        System.out.println("Person Phone No: " + p.getPhone());
        
        System.out.println();
        System.out.println("------------Person's Address Details are:---------");
        itr= a1.iterator();
        while(itr.hasNext())
        {
        	Address ad=itr.next();
        	System.out.println(ad.getAddressId() + ":" + ad.getDoorNo() + ":" + ad.getStreetName() + ":" + ad.getCity() + ":" + ad.getState());
        }
        
        */
        
        session.close();
        }catch(Exception e){
            e.printStackTrace();
        }    
    }
                

}
