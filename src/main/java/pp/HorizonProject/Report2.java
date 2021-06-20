//Zestawienie po projektach - Dostajemy katalog z danymi i podajemy 
//rok a wypluc mamy sumaryczna liczbe godizn w danym roku poswiecona na dany projekt (dodatkowo wykres slupkowy)
package pp.HorizonProject;

import java.util.ArrayList;


public class Report2 extends Report {
	DataModel database;
	ArrayList<Project> projects = database.getProjects();

	public Report2(DataModel database) {
		this.database = database;
	}
	
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
