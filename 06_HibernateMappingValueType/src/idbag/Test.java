/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idbag;

 
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Ramanath
 */
public class Test {
    public static void main(String arg[]){
        Session session=HibernateUtil.getSessionFactory().openSession();
        BagParent parent=new BagParent();
        parent.setId(1);

        List images=new ArrayList();
        images.add("first");
        images.add("first");
        parent.setBagImages(images);

        session.beginTransaction();
        session.save(parent);
        session.getTransaction().commit();
    }
}
