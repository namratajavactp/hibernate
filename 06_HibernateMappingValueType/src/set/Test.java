/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package set;

 
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;

 
public class Test {
    public static void main(String arg[]){
        Session session=HibernateUtil.getSessionFactory().openSession();
        SetParent parent=new SetParent();
        parent.setId(1);

        Set images=new HashSet();
        images.add("first");
        images.add("second");
        parent.setSetImages(images);
        session.beginTransaction();
        session.save(parent);
        session.getTransaction().commit();
    }
}
