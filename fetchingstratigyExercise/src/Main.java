/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;


public class Main {

    
    public static void main(String[] args) {
        // TODO code application logic here
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        Set<Bid> set=new HashSet<Bid>();
        
        
        Item item=new Item();
        item.setItemid(1);
        item.setName("abcd");
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
    }

}
