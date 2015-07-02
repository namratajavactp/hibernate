/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manytomanyBD;

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
        
        Address ad3=new Address();
        ad3.setAddressId(203);
        ad3.setDoorNo(102);
        ad3.setStreetName("Aduvalli");
        ad3.setCity("Hassan");
        ad3.setState("Karnataka");
        
        
        Set<Address> addresses1= new HashSet<Address>();
        Set<Person>  persons=new HashSet<Person>();
        
        addresses1.add(ad1);
        addresses1.add(ad3);
  
        
        
        //person entity
        Person p1=new Person();
        p1.setPersonId(1L);
        p1.setName("Ram");
        p1.setPhone(123123312L);
        p1.setAddresses(addresses1);
        
        Person p2=new Person();
        p2.setPersonId(2L);
        p2.setName("Raju");
        p2.setPhone(3435345456l);
        
        Person p3=new Person();
        p3.setPersonId(3L);
        p3.setName("Rakesh");
        p3.setPhone(34543534);
        
        persons.add(p2);
        persons.add(p3);
        
        ad2.setPersons(persons);
        
        //opening session and starting transaction
        Session session=HibernateUtility.getSession();
        
        Transaction t=session.beginTransaction();
        //persisting person              
        session.save(p1);
        session.save(ad2);
        
        //closing transaction
         
        /* 
         //searching person on id
        Person p=(Person)session.get(Person.class,new Long(1l));
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
        
     System.out.println("----------------------------------------------------------------------");
     Address a=(Address)session.get(Address.class,new Long(202));
     Set<Person> per=(Set)a.getPersons();
     System.out.println("-----------Address Details: -------------");
     System.out.println("Addr Id: " + a.getAddressId());
     System.out.println("Addr City: " + a.getCity());
     System.out.println("Addr State: " + a.getState());
     
     System.out.println();
     System.out.println("------------Person's  stayig in this Address  are:---------");
     Iterator<Person> itr1= per.iterator();
     while(itr1.hasNext())
     {
     	Person pd=itr1.next();
     	System.out.println(pd.getPersonId() + ":" + pd.getName() + ":" + pd.getPhone() );
     }
  
        
         */
        
     t.commit();  
        
        session.close();
       
        
        }catch(Exception e){
            e.printStackTrace();
        }    
    }
                

}
