package test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity  
@Table(name = "programs")  
public class Program_Years implements java.io.Serializable{
		
	private static final long serialVersionUID = 1L;
	
	String program_cd;
	String program_name;
	private Set<Periods_for_program_and_year> periods_for_program_and_year = new HashSet<Periods_for_program_and_year>(0);
	
	public Program_Years() {
		// TODO Auto-generated constructor stub
	}

	public Program_Years(String program_cd, String program_name) {
		super();
		this.program_cd = program_cd;
		this.program_name = program_name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.programcd", cascade=CascadeType.ALL)
	public Set<Periods_for_program_and_year> getPeriods_for_program_and_year() {
		return periods_for_program_and_year;
	}
		
	public void setPeriods_for_program_and_year(
			Set<Periods_for_program_and_year> periods_for_program_and_year) {
		this.periods_for_program_and_year = periods_for_program_and_year;
	}
	
	@Id
	@Column(name = "program_cd" ,unique = true, nullable = false) 
	public String getProgram_cd() {
		return program_cd;
	}
	public void setProgram_cd(String program_cd) {
		this.program_cd = program_cd;
	}
	
	@Column(name = "program_name", nullable = false, length = 20) 
	public String getProgram_name() {
		return program_name;
	}
	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}

	@Override
	public String toString() {
		return "Program_Years [program_cd=" + program_cd + ", program_name="
				+ program_name + "]";
	}
	
	
	
	
}
