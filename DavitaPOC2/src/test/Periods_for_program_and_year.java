package test;


import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "periods_for_program_and_year")
@AssociationOverrides({
		@AssociationOverride(name = "pk.programcd", 
			joinColumns = @JoinColumn(name = "program_cd")),
		@AssociationOverride(name = "pk.periodtypecd", 
			joinColumns = @JoinColumn(name = "period_type_cd")) })
public class Periods_for_program_and_year implements java.io.Serializable{
	
	private static final long serialVersionUID = 4050660680047579957L;

	private Periods_for_program_and_yearID pk = new Periods_for_program_and_yearID();
	private String year;
	
	
	@EmbeddedId
	public Periods_for_program_and_yearID getPk() {
		return pk;
	}
	public void setPk(Periods_for_program_and_yearID pk) {
		this.pk = pk;
	}
	
	@Transient
	public Program_Years getProgramcd() {
		return getPk().getProgramcd();
	}

	public void setProgramcd(Program_Years c) {
		getPk().setProgramcd(c);
	}
	

	@Transient
	public Period_Types getPeriodtypecd() {
		return getPk().getPeriodtypecd();
	}

	public void setPeriodtypecd(Period_Types c) {
		getPk().setPeriodtypecd(c);
	}
	
	
	@Column(name = "year", nullable = false, length = 10)
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	
	@Override
	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Periods_for_program_and_year))
			return false;
		Periods_for_program_and_year other = (Periods_for_program_and_year) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Periods_for_program_and_year [pk=" + pk + ", year=" + year
				+ "]";
	}
	
	
	
	

}
