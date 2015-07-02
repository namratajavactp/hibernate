/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package onetooneBD;
//one-to-one bidirectional mapping using shared primary key
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
       //ad1.setAddressId(1l);it wont work in the case f uncomment bcoz here person id itself is used as address id
        ad1.setDoorNo(101);
        ad1.setStreetName("MG Road");
        ad1.setCity("Bangalore");
        ad1.setState("Karnataka");
        
        Person p1=new Person();
        p1.setPersonId(1L);
        p1.setName("Ram");
        p1.setPhone(123123312L);
        p1.setAddress(ad1);
        ad1.setPerson(p1);
        System.out.println(p1);
        System.out.println(ad1);
        session.save(p1);
        
        t.commit();
         session.close(); 
       
       
        }catch(Exception e){
            e.printStackTrace();
        }    
    }
                

}
