/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package onetoonesimple;

import hibernate.HibernateUtility;

import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        try{
        	
     
            Session session=HibernateUtility.getSession();
            
            Transaction t=session.beginTransaction();
         
        Address ad1=new Address();
       ad1.setAddressId(1);
        ad1.setDoorNo(101);
        ad1.setStreetName("MG Road");
        ad1.setCity("Bangalore");
        ad1.setState("Karnataka");
        
        Person p1=new Person();
        p1.setPersonId(1L);
        p1.setName("Ram");
        p1.setPhone(123123312L);
        p1.setAddress(ad1);
      //  ad1.setPerson(p1);  
       
      session.save(ad1);
        session.save(p1);
        
        t.commit();
        session.close();
     /*
        Session session1=HibernateUtility.getSession();
        
        Transaction t1=session1.beginTransaction();
        
     Address tt=(Address)session1.load(onetoonesimple.Address.class,1L);
        Person po=tt.getPerson();
        System.out.println(po.getName());
        
        
        t1.commit();
        session1.close();
       
       */
        }catch(Exception e){
            e.printStackTrace();
        }    
    }
                

}
