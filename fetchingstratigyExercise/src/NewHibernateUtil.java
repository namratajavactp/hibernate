/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;


public class NewHibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
