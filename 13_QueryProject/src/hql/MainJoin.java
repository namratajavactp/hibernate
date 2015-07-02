package hql;
import java.util.*;
import java.util.Set;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class MainJoin {
public static void main(String[] args) throws Exception {
sampleWrite();
//sampleRead();
}
static Session getHibernateSession() throws MappingException,HibernateException, Exception
{
	Configuration config = new Configuration().configure();
	/*config.addClass(cs683.Person.class);
	config.addClass(cs683.EmailAddress.class);*/
	SessionFactory sessions = config.buildSessionFactory();
	Session session = sessions.openSession();
	return session;
}

static void sampleWrite() throws MappingException, HibernateException,Exception {
Session session = getHibernateSession();
Transaction save = session.beginTransaction();
Person newPerson = new Person("Susan",123L);

Address bar = new Address(1,"foo","mumbai","maharashtra");
//session.save(bar);
Address cat = new Address(2,"coo","pune","maharashtra");
//session.save(cat);

List<Address> a=new ArrayList<Address>();
a.add(cat);
a.add(bar);
newPerson.setAddresses(a);

session.save(newPerson);

save.commit();
session.close();
}

/*
static void sampleRead() throws MappingException, HibernateException,
Exception {
Session session = getHibernateSession();
Query getPerson =
session.createQuery(" from Person p left join p.addresses address");
//session.createQuery("from EmailAddress");
List result = getPerson.list();
System.out.println("Number of Objects: " + result.size());

Iterator i=result.iterator();
while (i.hasNext())
{
	Object[] o =(Object[])i.next();
	Person p=(Person)o[0];
	Address e =(Address)o[1];
	System.out.println(p.getName()+" "+e.getCity());
	//EmailAddress e=(EmailAddress)i.next();
	//System.out.println(e.getUserName());
}
//System.out.println(addresses);//.getClass());
session.close();
} */
}