package pp.HorizonProject.DataExtraction;

import java.util.ArrayList;

import pp.HorizonProject.DataExtraction.Task;

public class Project {
	
	String name;
	
	ArrayList<Task> tasks = new ArrayList<>();;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Task> getTasks() {
		return tasks;
	}
	
}
