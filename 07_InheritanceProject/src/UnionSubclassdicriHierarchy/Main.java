 


package UnionSubclassdicriHierarchy;

import org.hibernate.Session;
 
public class Main {

     
    public static void main(String[] args) {
        // TODO code application logic here
        
        CreditCard cc=new CreditCard();
        cc.setBillingid(1);
        cc.setExpMonth("apr");
        cc.setExpYear("2009");
        cc.setNumber("122131231");
        cc.setOwner("abcd");
      
        BankAccount acc=new BankAccount();
        acc.setBillingid(2);
        acc.setAccount("ba");
        acc.setBankName("abcd");
        acc.setOwner("ddd");
        acc.setSwift("abcddd");
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(cc);
        session.save(acc);
        session.getTransaction().commit();
    }

}
