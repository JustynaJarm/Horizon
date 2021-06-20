//Szczegolowy wykaz pracy danego pracownika - na wejsciu wybieramy rok oraz pracownika 
//- wypisac powinnismy tabele w ktorej bedzie podany miesiac a w niej projekty i ile godizn na nie poswiecil
package main.java.pp.HorizonProject;

import java.util.ArrayList;

import main.java.pp.HorizonProject.Project;
import main.java.pp.HorizonProject.Worker;
import main.java.pp.HorizonProject.Task;
import main.java.pp.HorizonProject.Report;
import main.java.pp.HorizonProject.DataModel;

public class Report3 {
	DataModel database = new DataModel();
	ArrayList<Worker> workers = database.getWorkers();
	
	public void printReport(int year, String selectedWorker) {
		System.out.println("3. Szczegó³owy wykaz pracy danego pracownika (raport III)");
		System.out.println("Raport dla pracownika: " + selectedWorker + "(rok: " + year + ")");
		
		Worker foundWorker = findWorker(selectedWorker);
		System.out.println("Found worker!" + foundWorker.getFullName());
//		for (Worker worker : workers) {
//			int workTimeInYearByProject = 0;
//			
//			for (Task task : project.getTasks()) {
//				if (task.getDate().getYear() == year) {
//					workTimeInYearByProject += task.getTime();					
//				}
//			}
//			
//			System.out.println("Worker: " + project.getName() + " Time: " + workTimeInYearByProject);
//		}
	}
	
	public Worker findWorker(String workerToFind) {
		Worker foundWorker = null;
		
		for (Worker worker : workers) {
			if (worker.getFullName() == workerToFind) {
				return foundWorker = worker;
			}
		}
		
		return foundWorker;
	}
}
