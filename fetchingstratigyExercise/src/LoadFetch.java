/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




import java.util.Date;
import org.hibernate.Session;


public class LoadFetch {
public static void main(String[] args) {
        
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        Item item=(Item)session.get(Item.class, 1);
        System.out.println(item.getItemid()+(new Date().toString()));
        try{
            Thread.sleep(5000);
        }
        catch(Exception e){}
        System.out.println(item.getName()+new Date());
    }
}
