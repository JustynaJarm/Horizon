package pp.HorizonProject.DataExtraction;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class Task {
	
	public String name;
	public Date date;
	public Double time;
	public Worker owner;
	public Project project;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getTime() {
		return time;
	}
	public void setTime(Double time) {
		this.time = time;
	}
	public Worker getOwner() {
		return owner;
	}
	public void setOwner(Worker owner) {
		this.owner = owner;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	
	

}
