//1. Wygenerowanie alfabetycznie pracownikow z liczba godzin jaka 
//przepracowal w danym roku (program dostaje wskazanie na katalog z danymi 
//a wypisac ma tabele posortowana po nazwiskach z danymi - sumaryczne godziny w roku)
package pp.HorizonProject.Reports;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;

import pp.HorizonProject.DataExtraction.DataModel;
import pp.HorizonProject.DataExtraction.Task;
import pp.HorizonProject.DataExtraction.Worker;

public class Report1 extends Report {
	DataModel database;
	ArrayList<Worker> workers;
	List<String[]> rows = getRows();
	String[] headers = getHeaders();
	
	public Report1(DataModel database) {
		this.database = database;
		this.workers = database.getWorkers();
	}
	
	public ArrayList<Worker> printReport(int year) {
		System.out.println("1. Alfabetyczne Wypisanie Pracownikow (raport I)");
		System.out.println("Raport za rok: " + year);
		
		int lp = 1;
		workers.sort((worker1, worker2) -> worker1.getLastName().compareTo(worker2.getLastName()));
		setHeaders("Lp.", "Imie i nazwisko", "Liczba godzin w roku");
		
		for (Worker worker : workers) {
			double workTimeInYearByWorker = 0;
			
			for (Task task : worker.getTasks()) {
				if (task.getDate().getYear() == year) {
					workTimeInYearByWorker += task.getTime();
				}
			}
			
			addRow(String.valueOf(lp), worker.getFullName(), String.valueOf(workTimeInYearByWorker));
			lp++;
		}
		
		print();
		return workers;
	}
}
