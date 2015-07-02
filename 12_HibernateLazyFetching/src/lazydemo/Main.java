/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lazydemo;

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
        
        Address ad4=new Address();
        ad4.setAddressId(204);
        ad4.setDoorNo(502);
        ad4.setStreetName("chakkala");
        ad4.setCity("Nagpur");
        ad4.setState("Maharashtra");
        
        Set<Address> addresses1= new HashSet<Address>();
        Set<Address> addresses2=new HashSet<Address>();
        
        addresses1.add(ad1);
        addresses1.add(ad3);
        
        addresses2.add(ad2);
        addresses2.add(ad4);
        
        
        
        
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
        p2.setAddresses(addresses2);
        
        //opening session and starting transaction
        Session session=HibernateUtility.getSession();
        
        Transaction t=session.beginTransaction();
        //persisting person              
        session.save(p1);
        session.save(p2);
        //closing transaction
         t.commit();
         
         //searching person on id
                
        session.close();
        }catch(Exception e){
            e.printStackTrace();
        }    
    }
                

}
