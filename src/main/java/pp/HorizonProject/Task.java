package pp.HorizonProject;
import java.util.Date;

import pp.HorizonProject.Project;
import pp.HorizonProject.Worker;

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
	public Date getDate() {
		return date;
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
