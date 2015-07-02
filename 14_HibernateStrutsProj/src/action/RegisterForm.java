package action;

import org.apache.struts.action.*;

public class RegisterForm extends ActionForm{
	protected int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	protected String uname;
	protected String password1;
	protected String password2;
	
	public String getUname() {return uname;}
	public String getPassword1() {return password1;}
	public String getPassword2() {return password2;}	

	public void setUname(String uname) {this.uname=uname;}
	public void setPassword1(String password1) {this.password1=password1;}
	public void setPassword2(String password2) {this.password2=password2;}	
}