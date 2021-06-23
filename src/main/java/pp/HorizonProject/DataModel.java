package pp.HorizonProject;

import java.util.ArrayList;

import pp.HorizonProject.Project;
import pp.HorizonProject.Worker;
import pp.HorizonProject.Task;

public class DataModel {
	ArrayList<Project> projects = new ArrayList<Project>();
	ArrayList<Worker> workers = new ArrayList<Worker>();
	ArrayList<Task> tasks = new ArrayList<Task>();
	
	public ArrayList<Project> getProjects() {
		return projects;
	}
	
	public ArrayList<Worker> getWorkers() {
		return workers;
	}
	
	public ArrayList<Task> getTasks() {
		return tasks;
	}

}
