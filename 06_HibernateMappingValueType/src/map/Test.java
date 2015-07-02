/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

 
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.hibernate.Session;

 
public class Test {
    public static void main(String arg[]){
        Session session=HibernateUtil.getSessionFactory().openSession();
        MapParent parent=new MapParent();
        parent.setId(1);

        Map images=new HashMap();
        images.put("1","first");
        images.put("2","second");
        parent.setMapImages(images);
        session.beginTransaction();
        session.save(parent);
        session.getTransaction().commit();
    }
}
