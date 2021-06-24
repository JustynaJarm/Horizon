//Szczegolowy wykaz pracy danego pracownika - na wejsciu wybieramy rok oraz pracownika 
//- wypisac powinnismy tabele w ktorej bedzie podany miesiac a w niej projekty i ile godizn na nie poswiecil
package pp.HorizonProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.time.Month;

import pp.HorizonProject.Project;
import pp.HorizonProject.Task;

public class Report3 extends Report{
	DataModel database = new DataModel();
//	ArrayList<Project> projects;
	ArrayList<Worker> workers;
	
	public Report3(DataModel database) {
		this.database = database;
//		this.projects = database.getProjects();
		this.workers = database.getWorkers();
	}
	
	public void printReport(int year, String selectedWorker) {
		System.out.println("3. Szczegółowy wykaz pracy danego pracownika (raport III)");
		System.out.println("Raport dla pracownika: " + selectedWorker + "(rok: " + year + ")");
		
		setHeaders("Lp.", "Miesiąc", "Projekt", "Liczba godzin");
		Worker foundWorker = findWorker(selectedWorker);
//		ArrayList<ProjectTimeByMonth> timeSpentOnProjectInMonthObjects = new ArrayList<ProjectTimeByMonth>();
//		Task[] tasksToPrint = {foundWorker.getTasks().get(0)};
		ArrayList<Task> tasksToPrint = new ArrayList<Task>();
		ArrayList<Task> extraSet = foundWorker.getTasks();
//		Set<Task> tasksToPrint = new HashSet<>();
		int lp = 1;
		
		for (Task task : foundWorker.getTasks()) {
			if (task.getDate().getYear() == year) {
//				timeSpentOnProjectInMonthObjects.add(new ProjectTimeByMonth(task.getDate().getMonth(), task.getProject().getName(), task.getTime()));
				if (tasksToPrint.size() == 0) {
					tasksToPrint.add(task);
				}
				for (Task t : extraSet) {
					if ((task.getDate().getMonth().equals(t.getDate().getMonth())) && (task.getProject().getName().equals(t.getProject().getName()))) {
						task.setTime(t.getTime() + task.getTime());
					}
				}
				tasksToPrint.add(task);
//				for (int i=0; i<tasksToPrint.size(); i++) {
//					if ((task.getDate().getMonth().equals(tasksToPrint.get(i).getDate().getMonth()))
//					&& (task.getProject().getName().equals(tasksToPrint.get(i).getProject().getName()))) {
//						tasksToPrint.get(i).setTime(tasksToPrint.get(i).getTime() + task.getTime());
//					} else {
//						tasksToPrint.add(task);
//						System.out.println(tasksToPrint.size());
//					}
//				}
//				for (Iterator<Task> it = tasksToPrint.iterator(); it.hasNext();) {
//					Task t = it.next();
//					if ((task.getDate().getMonth().equals(t.getDate().getMonth())) && (task.getProject().getName().equals(t.getProject().getName()))) {
//						t.setTime(t.getTime() + task.getTime());
//						System.out.println("if");
//					} else {
//						System.out.println("else");
//						tasksToPrint.add(task);
//					}
//				}
//				for (int i=0; i<tasksToPrint.length; i++) {
//					if ((task.getDate().getMonth().equals(tasksToPrint[i].getDate().getMonth())) 
//						&& (task.getProject().getName().equals(tasksToPrint[i].getProject().getName()))) {
//						tasksToPrint[i].setTime(tasksToPrint[i].getTime() + task.getTime());
//					} else {
//						tasksToPrint = Arrays.copyOf(tasksToPrint, tasksToPrint.length + 1);
//						tasksToPrint[tasksToPrint.length - 1] = task;
//						System.out.println(tasksToPrint.length);
//					}
//				}
//				for (Task t : tasksToPrint) {
//					if ((task.getDate().getMonth().equals(t.getDate().getMonth())) && (task.getProject().getName().equals(t.getProject().getName()))) {
//						t.setTime(t.getTime() + task.getTime());
//						System.out.println("if");
//					} else {
//						System.out.println("else");
//						tasksToPrint.add(task);
//					}
//				}
			}
			
		}

//		for (ProjectTimeByMonth singleValue : timeSpentOnProjectInMonthObjects) {
		for (Task task : tasksToPrint) {
			addRow(String.valueOf(lp), String.valueOf(task.getDate().getMonth()), task.getProject().getName(), String.valueOf(task.getTime()));
			lp++;
		}
		
		print();
			
//		for (Project project : projects) {
//			int timeSpentOnProject = 0;
//					
//			for (Task task : project.getTasks()) {
//				if ((task.getDate().getYear() == year) && (task.getOwner().getFullName() == selectedWorker)) {
//					
//				}
//				addRow(String.valueOf(lp), project.getName(), String.valueOf(timeSpentOnProject));
//			}
//
//			lp++;
//		}
//		
//		print();
	}
	
	public Worker findWorker(String workerToFind) {
		Worker foundWorker = null;
		
		for (Worker worker : workers) {
			if (worker.getFullName().equals(workerToFind)) {
				return foundWorker = worker;
			}
		}
		
		return foundWorker;
	}
}
