/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package list;

 
import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;

 
public class Test {
    public static void main(String arg[]){
        Session session=HibernateUtil.getSessionFactory().openSession();
        ListParent parent=new ListParent();
        parent.setId(1);

        List images=new ArrayList();
        
        images.add("first");
        images.add("second");
        images.add("third");
        
        parent.setListImages(images);
        session.beginTransaction();
        session.save(parent);
        session.getTransaction().commit();
    }
}
