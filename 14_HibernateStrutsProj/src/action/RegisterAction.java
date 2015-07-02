package action;

import org.apache.struts.action.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.HibernateUtility;

import javax.servlet.http.*;
import javax.sql.*;
import javax.naming.*;
import java.sql.*;

public class RegisterAction extends Action{
	public ActionForward perform (ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res){
		RegisterForm rf = (RegisterForm) form;
		
		String uname = rf.getUname();
		String pass1 = rf.getPassword1();
		String pass2 = rf.getPassword2();
		
		if(pass1.equals(pass2))
		{
			try
			{
				Session session=HibernateUtility.getSession();
			
			Transaction tx= session.beginTransaction();
			session.save(rf);
			tx.commit();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return mapping.findForward("success");
		}
		else
			return mapping.findForward("failure");
	}
}