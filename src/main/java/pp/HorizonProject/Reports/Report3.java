//Szczegolowy wykaz pracy danego pracownika - na wejsciu wybieramy rok oraz pracownika 
//- wypisac powinnismy tabele w ktorej bedzie podany miesiac a w niej projekty i ile godizn na nie poswiecil
package pp.HorizonProject.Reports;

import java.util.ArrayList;
import java.util.Iterator;

import pp.HorizonProject.DataExtraction.DataModel;
import pp.HorizonProject.DataExtraction.Task;
import pp.HorizonProject.DataExtraction.Worker;

public class Report3 extends Report{
	DataModel database = new DataModel();
	ArrayList<Worker> workers;
	
	public Report3(DataModel database) {
		this.database = database;
		this.workers = database.getWorkers();
	}
	
	public ArrayList<Task> printReport(int year, String selectedWorker) {
		System.out.println("3. Szczegółowy wykaz pracy danego pracownika (raport III)");
		System.out.println("Raport dla pracownika: " + selectedWorker + "(rok: " + year + ")");
		
		setHeaders("Lp.", "Miesiąc", "Projekt", "Liczba godzin");
		Worker foundWorker = findWorker(selectedWorker, this.workers);
		ArrayList<Task> tasksToPrint = new ArrayList<Task>();
		int lp = 1;
		
		for (Task task : foundWorker.getTasks()) {
			if (task.getDate().getYear() == year) {
				if (tasksToPrint.size() == 0) {
					tasksToPrint.add(task);
				}
				for (Iterator<Task> iterator = tasksToPrint.iterator(); iterator.hasNext();) {
					Task t = iterator.next();
					if ((task.getDate().getMonth().equals(t.getDate().getMonth())) && (task.getProject().getName().equals(t.getProject().getName()))) {
						task.setTime(t.getTime() + task.getTime());
						iterator.remove();
					}
				}
				tasksToPrint.add(task);
			}
		}

		for (Task task : tasksToPrint) {
			addRow(String.valueOf(lp), String.valueOf(task.getDate().getMonth()), task.getProject().getName(), String.valueOf(task.getTime()));
			lp++;
		}
		
		print();
		return tasksToPrint;
	}
	
	// Dodałem workers jako parametr, aby w testach móc wstawiać dowolną tablicę
	public Worker findWorker(String workerToFind, ArrayList<Worker> workers ) {
		Worker foundWorker = null;
		ArrayList<Worker> workersToSearch = workers;
		
		for (Worker worker : workersToSearch) {
			if (worker.getFullName().equals(workerToFind)) {
				return foundWorker = worker;
			}
		}
		
		return foundWorker;
	}
}
