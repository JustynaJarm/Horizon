//Zestawienie po projektach - Dostajemy katalog z danymi i podajemy 
//rok a wypluc mamy sumaryczna liczbe godizn w danym roku poswiecona na dany projekt (dodatkowo wykres slupkowy)
package main.java.pp.HorizonProject;

import java.util.ArrayList;

import main.java.pp.HorizonProject.Project;
import main.java.pp.HorizonProject.Task;
import main.java.pp.HorizonProject.Report;
import main.java.pp.HorizonProject.DataModel;

public class Report2 extends Report {
	DataModel database = new DataModel();
	ArrayList<Project> projects = database.getProjects();
	
	public void printReport(int year) {
		System.out.println("2. Zestawienie Po Projektach (raport II)");
		System.out.println("Raport za rok: " + year);
		
		for (Project project : projects) {
			int workTimeInYearByProject = 0;
			
			for (Task task : project.getTasks()) {
				if (task.getDate().getYear() == year) {
					workTimeInYearByProject += task.getTime();					
				}
			}
			
			System.out.println("Worker: " + project.getName() + " Time: " + workTimeInYearByProject);
		}
	}
}
