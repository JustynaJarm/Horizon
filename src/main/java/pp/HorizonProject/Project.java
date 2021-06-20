package main.java.pp.HorizonProject;

import java.util.Collection;

import main.java.pp.HorizonProject.Task;

public class Project {
	
	String name;
	
	Collection<Task> tasks;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addTask(Task task) {
		this.tasks.add(task);
	}

}
