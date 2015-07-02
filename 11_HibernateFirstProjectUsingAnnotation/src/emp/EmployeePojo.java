package emp;
import java.io.Serializable;

import javax.persistence.*;
//import org.hibernate.annotations.*;
@Entity
@Table(name="hello")
public class EmployeePojo  
{
	public EmployeePojo() {
		
	}
	@Id
	
	@Column(name="employeeid")
	Integer empid;
	
	@Column(name="empname", nullable=true)
	String name;
	
	@Column(name="empsalary")
	Double salary;

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
		
	

}
