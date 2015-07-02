/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thirdTablePerConcreteClass;

import hibernate.HibernateUtility;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.omg.CORBA.TRANSACTION_MODE;

public class Test {

   public static void main(String[] args) {
        
        try{
        Session session=HibernateUtility.getSession();
        Transaction transaction=session.beginTransaction();
        
     /*   Disc disc=new Disc();
        disc.setId(101l);
        disc.setName("PhoneDirectory");
        disc.setPrice(300);  */
        
   //     AudioDisc audioDisc=new AudioDisc();
        Disc audioDisc=new AudioDisc();
        audioDisc.setId(102l);
        audioDisc.setName("Harmony");
        audioDisc.setPrice(350);
        ((AudioDisc)audioDisc).setSinger("Jagjeet Sing");
        ((AudioDisc)audioDisc).setNumOfSongs(12);
        
      //  VideoDisc videoDisc=new VideoDisc();
        Disc videoDisc =new VideoDisc();
        videoDisc.setId(103l);
        videoDisc.setName("Jurasic park");
        videoDisc.setPrice(500);
        ((VideoDisc)videoDisc).setDirector("Stephn Spillberg");
        ((VideoDisc)videoDisc).setLanguage("English");
        
        //session.save(disc);
        session.save(audioDisc);
        session.save(videoDisc);
     
       
        transaction.commit();
        session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
       
        
        
    }

}
