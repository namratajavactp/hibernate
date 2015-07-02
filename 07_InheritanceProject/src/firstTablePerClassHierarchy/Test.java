package firstTablePerClassHierarchy;

import hibernate.HibernateUtility;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) 
	{
	  try
	  {
		Session ses= HibernateUtility.getSession();
		Transaction tx=ses.beginTransaction();
		tx.begin();
		
		
		
		AudioDisc audioDisc= new AudioDisc();
		audioDisc.setName("Harmony");
        audioDisc.setPrice(350);  
        audioDisc.setSinger("Jagjeet Sing");
        audioDisc.setNumOfSongs(12);
        
       
        VideoDisc videoDisc=new VideoDisc();
        videoDisc.setName("Jurasic park");
        videoDisc.setPrice(500);
        videoDisc.setDirector("Stephn Spillberg");
        videoDisc.setLanguage("English");
        
        
        
         
        ses.save(audioDisc);
        ses.save(videoDisc);
       
        tx.commit();
        ses.close();
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	}

}
