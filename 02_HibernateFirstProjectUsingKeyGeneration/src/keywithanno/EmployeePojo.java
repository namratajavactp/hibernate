package keywithanno;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="annokeypojoemp")
@GenericGenerator(name="h-uid", strategy="uuid")//empid must be string change corresponding setter and getter
//@GenericGenerator(name="h-uid", strategy="guid")//empid must be string
//@GenericGenerator(name="h-uid", strategy="hilo")// empid must long or int
public class EmployeePojo 
{
	@Id
	@GeneratedValue(generator="h-uid")
	private String empid;
	//private int empid;
	private String name;
	private double salary;
	
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	
	public String getName() {
		return name;
	}
	/*public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}*/
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	

}
