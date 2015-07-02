import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;


public class SimpleEventDao implements SimpleEventDaoInterface {
    //Log log = LogFactory.getLog(SimpleEventDao.class);
    private Session session;
    private Transaction tx;

    public SimpleEventDao() {
       
    }
 
    public void create(Event event) throws DataAccessLayerException {
        try {
            startOperation();
            session.save(event);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            session.close();
        }
    }
     
    public void delete(Event event) throws DataAccessLayerException {
        try {
            startOperation();
            session.delete(event);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
        	 session.close();
        }
    }
     
    public Event find(Long id) throws DataAccessLayerException {
        Event event = null;
        try {
            startOperation();
            event = (Event) session.load(Event.class, id);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            //HibernateFactory.close(session);
        }
        return event;
    }

     
    public void update(Event event) throws DataAccessLayerException {
        try {
            startOperation();
            session.update(event);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
        	 session.close();
        }
    }

    
    public List findAll() throws DataAccessLayerException{
        List events = null;
        try {
            startOperation();
            Query query = session.createQuery("from Event");
            events =  query.list();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
        	 session.close();
        }
        return events;
    }

    private void handleException(HibernateException e) throws DataAccessLayerException {
       
        throw new DataAccessLayerException(e);
    }

    private void startOperation() throws HibernateException {
    	session= HibernateUtility.getSession();
        tx = session.beginTransaction();
    }

}
