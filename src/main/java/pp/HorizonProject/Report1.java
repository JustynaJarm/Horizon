//	1. Wygenerowanie alfabetycznie pracownikow z liczba godzin jaka 
//przepracowal w danym roku (program dostaje wskazanie na katalog z danymi 
//a wypisac ma tabele posortowana po nazwiskach z danymi - sumaryczne godziny w roku)
package main.java.pp.HorizonProject;

import java.util.ArrayList;

import main.java.pp.HorizonProject.Worker;
import main.java.pp.HorizonProject.Task;
import main.java.pp.HorizonProject.Report;
import main.java.pp.HorizonProject.DataModel;

public class Report1 extends Report {
	DataModel database = new DataModel();
	ArrayList<Worker> workers = database.getWorkers();
	
	public void printReport(int year) {
		System.out.println("1. Alfabetyczne Wypisanie Pracownikow (raport I)");
		System.out.println("Raport za rok: " + year);
		
		for (Worker worker : workers) {
			int workTimeInYearByWorker = 0;
			
			for (Task task : worker.getTasks()) {
				if (task.getDate().getYear() == year) {
					workTimeInYearByWorker += task.getTime();					
				}
			}
			
			System.out.println("Worker: " + worker.getFullName() + " Time: " + workTimeInYearByWorker);
		}
	}
}
