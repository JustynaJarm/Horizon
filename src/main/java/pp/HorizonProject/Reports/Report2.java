//Zestawienie po projektach - Dostajemy katalog z danymi i podajemy 
//rok a wypluc mamy sumaryczna liczbe godizn w danym roku poswiecona na dany projekt (dodatkowo wykres slupkowy)
package pp.HorizonProject.Reports;

import java.util.ArrayList;

import pp.HorizonProject.DataExtraction.DataModel;
import pp.HorizonProject.DataExtraction.Project;
import pp.HorizonProject.DataExtraction.Task;


public class Report2 extends Report {
	DataModel database;
	ArrayList<Project> projects;

	public Report2(DataModel database) {
		this.database = database;
		this.projects = database.getProjects();
	}
	
	public ArrayList<Project> printReport(int year) {
		System.out.println("2. Zestawienie Po Projektach (raport II)");
		System.out.println("Raport za rok: " + year);
		
		projects.sort((project1, project2) -> project1.getName().compareTo(project2.getName()));
		setHeaders("Lp.", "Projekt", "Liczba godzin w roku");
		
		int lp = 1;
		for (Project project : projects) {
			int workTimeInYearByProject = 0;
			
			for (Task task : project.getTasks()) {
				if (task.getDate().getYear() == year) {
					workTimeInYearByProject += task.getTime();		
				}
			}
			
			addRow(String.valueOf(lp), project.getName(), String.valueOf(workTimeInYearByProject));
			lp++;
		}
		
		print();
		return projects;
	}
}
