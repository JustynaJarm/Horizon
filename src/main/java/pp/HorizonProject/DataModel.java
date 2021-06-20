package main.java.pp.HorizonProject;

import java.util.ArrayList;

import main.java.pp.HorizonProject.Project;
import main.java.pp.HorizonProject.Worker;
import main.java.pp.HorizonProject.Task;

public class DataModel {
	ArrayList<Project> projects = new ArrayList<Project>();
	ArrayList<Worker> workers = new ArrayList<Worker>();
	ArrayList<Task> tasks = new ArrayList<Task>();
	
	public void addProject(Project project) {
		this.projects.add(project);
	}
	
	public void addWorker(Worker worker) {
		this.workers.add(worker);
	}
	
	public void addTask(Task task) {
		this.tasks.add(task);
	}

}
