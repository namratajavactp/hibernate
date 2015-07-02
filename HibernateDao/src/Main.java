
import java.util.*;

import org.hibernate.*;
import org.hibernate.criterion.*;

public class Main {
    
    public static void main(String[] args) {
        
        
        SimpleEventDaoInterface eventDao = new SimpleEventDao();
        
         System.out.println("Performing create Dao operation....");
        Event event1 = new Event();
        event1.setName("JavaOne conference");
        event1.setDuration(16);
        event1.setBudget(2000);
        eventDao.create(event1);
        
        Event event2 = new Event();
        event2.setName("Noname conference");
        event2.setDuration(16);
        event2.setBudget(2000);
        eventDao.create(event2); 
         
        
         System.out.println("Performing delete operation...");
         Event event3 = new Event();
       event1.setId(1l);
       eventDao.delete(event3);
        //System.out.println("Number of entries in the database table = " + eventList.size());
        
         
        
         
    }
    
}