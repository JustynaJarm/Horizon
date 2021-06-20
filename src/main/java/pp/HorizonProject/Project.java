package main.java.pp.HorizonProject;

import java.util.ArrayList;

import main.java.pp.HorizonProject.Task;

public class Project {
	
	String name;
	
	ArrayList<Task> tasks;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Task> getTasks() {
		return tasks;
	}
	
	public void addTask(Task task) {
		this.tasks.add(task);
	}

}
