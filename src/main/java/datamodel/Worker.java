package datamodel;

import java.util.Collection;

public class Worker {
	String lastName;
	String fullName;
	
	Collection<Task> tasks;

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
	
	public void addTask(Task task) {
		this.tasks.add(task);
	}

}
