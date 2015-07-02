package secondTablePerSubClass;

import org.hibernate.Session;

import hibernate.HibernateUtility;

public class Query {
	public static void main(String arg[])throws Exception{
		Session session=HibernateUtility.getSession();
		//polymorphic query
	Disc d1=(Disc)session.get(Disc.class, 12L);
		System.out.println(d1.getName());
		System.out.println(d1.getPrice());

		
		if(d1 instanceof AudioDisc)
		{	System.out.println(((AudioDisc)d1).getSinger());
		System.out.println(((AudioDisc)d1).getNumOfSongs());
		}
	
		
		session.close();
		
	}
}
