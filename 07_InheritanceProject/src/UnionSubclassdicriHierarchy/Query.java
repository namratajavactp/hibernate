package UnionSubclassdicriHierarchy;

import org.hibernate.Session;



import hibernate.HibernateUtility;

public class Query {
	public static void main(String arg[])throws Exception{
	
		Session session=HibernateUtility.getSession();
		BillingDetails d11=(BillingDetails)session.get(BillingDetails.class, 2);
		System.out.println(d11.getOwner());
		System.out.println(d11.getBillingid());
 
		System.out.println(((BankAccount)d11).getAccount());
		System.out.println(((BankAccount)d11).getBankName());	
	
	}
}
