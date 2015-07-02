package test;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class Periods_for_program_and_yearID implements java.io.Serializable{
	
	private static final long serialVersionUID = -9120607274421816301L;
	private Program_Years programcd;
	private Period_Types periodtypecd;
	
	@ManyToOne
	public Program_Years getProgramcd() {
		return programcd;
	}
	public void setProgramcd(Program_Years programcd) {
		this.programcd = programcd;
	}
	
	@ManyToOne
	public Period_Types getPeriodtypecd() {
		return periodtypecd;
	}
	public void setPeriodtypecd(Period_Types periodtypecd) {
		this.periodtypecd = periodtypecd;
	}
	
	@Override
	public int hashCode() {
		 int result;
	        result = (programcd != null ? programcd.hashCode() : 0);
	        result = 17 * result + (periodtypecd != null ? periodtypecd.hashCode() : 0);
	        return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Periods_for_program_and_yearID))
			return false;
		Periods_for_program_and_yearID other = (Periods_for_program_and_yearID) obj;
		if (periodtypecd == null) {
			if (other.periodtypecd != null)
				return false;
		} else if (!periodtypecd.equals(other.periodtypecd))
			return false;
		if (programcd == null) {
			if (other.programcd != null)
				return false;
		} else if (!programcd.equals(other.programcd))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Periods_for_program_and_yearID [programcd=" + programcd
				+ ", periodtypecd=" + periodtypecd + "]";
	}
	
	
	

}
