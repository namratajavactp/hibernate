import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.LinkedHashSet;

public class Event implements Serializable {
    private Long id;
    private int duration;
    private String name;
    private int budget;

    public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public Event() {

    }

    public Event(String name) {
        this.name = name;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
 
    public String getName() { return name; }
    public void setName(String name) { this.name = name;   }

    
    
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

}
