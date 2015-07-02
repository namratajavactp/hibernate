package firstTablePerClassHierarchy;

import org.hibernate.Transaction;


import org.hibernate.Session;
import org.hibernate.*;
import hibernate.HibernateUtility;

public class Query {
	public static void main(String arg[])throws Exception{
		Session session=HibernateUtility.getSession();
		//polymorphic query
	Disc d1=(Disc)session.get(Disc.class, 2L);
		System.out.println(d1.getName());
		System.out.println(d1.getPrice());

	//	System.out.println(((AudioDisc)d1).getSinger());
		
		
		
		
		if(d1 instanceof AudioDisc)
		{	System.out.println(((AudioDisc)d1).getSinger());
		System.out.println(((AudioDisc)d1).getNumOfSongs());
		}
		else if(d1 instanceof VideoDisc)
		{
			System.out.println(((VideoDisc)d1).getDirector());
			System.out.println(((VideoDisc)d1).getLanguage());
			
		}
	
		
		session.close();
	}
}
