package pp.HorizonProject;

import java.util.ArrayList;

import pp.HorizonProject.Task;

public class Worker {
	String lastName;
	String fullName;
	
	ArrayList<Task> tasks = new ArrayList<>();

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

}
