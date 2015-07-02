package onetomany_anno;



import java.util.Collection;
import java.util.LinkedList;
import org.hibernate.Session;

 
public class Test {
public static void main(String[] arg){
    Session session=HibernateUtil.getSessionFactory().openSession();
   
    First f=new First();
    Second s=new Second();
    f.setFirstid(1);
    f.setName("abcd");
    Collection<Second>  c=new LinkedList<Second>();
    c.add(s);
    s.setFirstid(f);
    s.setAnother("xyz");
    s.setSecondid(1);
    f.setSecondCollection(c);
    session.beginTransaction();
    session.save(f);

    session.save(s);
    session.getTransaction().commit();
    
    //session.delete(f);
    //session.delete(s);
 //   session.getTransaction().commit();
}
}
