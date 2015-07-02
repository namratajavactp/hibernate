package test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity  
@Table(name = "Period_Types") 
public class Period_Types implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String period_type_cd;
	
	String period_type;
	
	private Set<Periods_for_program_and_year> periods_for_program_and_year = new HashSet<Periods_for_program_and_year>(0);
	
public Period_Types() {
	// TODO Auto-generated constructor stub
}
	
	public Period_Types(String period_type_cd, String period_type) {
		super();
		this.period_type_cd = period_type_cd;
		this.period_type = period_type;
	}

	@Id
	@Column(name = "period_type_cd",unique = true, nullable = false) 
	public String getPeriod_type_cd() {
		return period_type_cd;
	}

	public void setPeriod_type_cd(String period_type_cd) {
		this.period_type_cd = period_type_cd;
	}

	@Column(name = "period_type", nullable = false, length = 10, unique = true)
	public String getPeriod_type() {
		return period_type;
	}

	public void setPeriod_type(String period_type) {
		this.period_type = period_type;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.periodtypecd")
	public Set<Periods_for_program_and_year> getPeriods_for_program_and_year() {
		return periods_for_program_and_year;
	}

	public void setPeriods_for_program_and_year(
			Set<Periods_for_program_and_year> periods_for_program_and_year) {
		this.periods_for_program_and_year = periods_for_program_and_year;
	}

	@Override
	public String toString() {
		return "Period_Types [period_type_cd=" + period_type_cd
				+ ", period_type=" + period_type + "]";
	}
	
	
	
	
}
