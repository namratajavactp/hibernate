package thirdTablePerConcreteClass;

import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.hibernate.Criteria;


import hibernate.HibernateUtility;

public class Query {
	public static void main(String arg[])throws Exception{
		Session session=HibernateUtility.getSession();
	    AudioDisc d1=(AudioDisc)session.get(AudioDisc.class, 102l);
		System.out.println(d1.getName());
		System.out.println(d1.getPrice());
 
		System.out.println(d1.getSinger());
		System.out.println(d1.getNumOfSongs());
		
		
	/*	
		Disc d11=(Disc)session.get(Disc.class, 102l);
		System.out.println(d11.getName());
		System.out.println(d11.getPrice());
 
		System.out.println(((AudioDisc)d11).getSinger());
		System.out.println(((AudioDisc)d11).getNumOfSongs());
*/		
		
		Disc c=(Disc)session.createCriteria(Disc.class).add(Restrictions.idEq(102l)).uniqueResult();
		System.out.println(c.getName());
		System.out.println(((AudioDisc)c).getSinger());
		
	}
}
