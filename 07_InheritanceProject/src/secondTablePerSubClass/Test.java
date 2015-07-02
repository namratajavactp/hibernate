package secondTablePerSubClass;

import java.util.Iterator;
import java.util.List;

import hibernate.HibernateUtility;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) 
	{
        try{
            Session session=HibernateUtility.getSession();
            Transaction transaction=session.beginTransaction();
            Disc disc=new Disc();
            
            disc.setName("TelephoneDirectory");
            disc.setPrice(300);
            
            AudioDisc audioDisc=new AudioDisc();
            
            audioDisc.setName("Harmony");
            audioDisc.setPrice(350);
            audioDisc.setSinger("Jagjeet Sing");
            audioDisc.setNumOfSongs(12);
            
            VideoDisc videoDisc=new VideoDisc();
          
            videoDisc.setName("Jurasic park");
            videoDisc.setPrice(500);
            videoDisc.setDirector("Stephn Spillberg");
            videoDisc.setLanguage("English");
            
            session.save(disc);
            session.save(audioDisc);
            session.save(videoDisc);
         /*
            Query q1=session.createQuery("from Disc");
            Query q2=session.createQuery("from AudioDisc");
            Query q3=session.createQuery("from VideoDisc");
            
            List l1=q1.list();
            List l2=q2.list();
            List l3=q3.list();
            Iterator it=l1.iterator();
            System.out.println("-------------------------------------------------------");
            System.out.println("DISC");
             while(it.hasNext()){
                Disc d=(Disc)it.next();
                System.out.println(d.getId());  
                System.out.println(d.getName());
                System.out.println(d.getPrice());
                System.out.println("----------------------------");
             }          
            System.out.println("AUDIODISC");
             it=l2.iterator();
            while(it.hasNext()){
                AudioDisc d=(AudioDisc)it.next();
                System.out.println(d.getId());
                System.out.println(d.getName());
                System.out.println(d.getPrice());
                System.out.println(d.getNumOfSongs());
                System.out.println(d.getSinger());    
                System.out.println("----------------------------");
            }
             System.out.println("VIDEODISC");
            it=l3.iterator();
             while(it.hasNext()){
                VideoDisc d=(VideoDisc)it.next();
                System.out.println(d.getId());
                System.out.println(d.getName());
                System.out.println(d.getPrice());
                System.out.println(d.getDirector());
                System.out.println(d.getLanguage());
                System.out.println("----------------------------");
             }
           */
            transaction.commit();
            session.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            
           
            
            
        }

    }
