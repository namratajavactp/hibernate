/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manytoonebidirectionalConfiguration;

 
import java.util.HashSet;

import hibernate.HibernateUtility;
import org.hibernate.Session;

public class Test {
    public static void main(String arg[]){
    	Session session=HibernateUtility.getSession();

        Bid bid=new Bid();
        bid.setBidid(1);
        bid.setAmount(10000);

        Item item=new Item();
        item.setItemid(1);
        item.setName("bottle");
        bid.setItemid(item);

        HashSet hs=new HashSet();
        hs.add(bid);
        item.setBids(hs);
        System.out.println(bid);
        session.beginTransaction();
        session.save(item);
        session.save(bid);
        session.getTransaction().commit();
    }
}
