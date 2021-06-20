package main.java.pp.HorizonProject;

import java.util.ArrayList;

import main.java.pp.HorizonProject.Task;

public class Worker {
	String lastName;
	String fullName;
	
	ArrayList<Task> tasks;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public ArrayList<Task> getTasks() {
		return tasks;
	}
	
	public void addTask(Task task) {
		this.tasks.add(task);
	}

}
