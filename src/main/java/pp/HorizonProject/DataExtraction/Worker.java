package pp.HorizonProject.DataExtraction;

import java.util.ArrayList;

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
