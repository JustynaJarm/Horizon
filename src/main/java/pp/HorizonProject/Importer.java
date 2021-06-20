package pp.HorizonProject;

import java.io.File;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Importer {
	
	public DataModel dataModel = new DataModel();
	
	public void readExactFile(File file) {
		Workbook wb = WorkbookFactory.create(file);
		
		// Checking if worker exists and if not, creating a new worker
		String fullName = readFileName(file);
		Boolean workerExists = false;
		Worker worker;
		for (Worker w : dataModel.workers) {
			if (w.getFullName().equals(fullName)){
				worker = w;
				workerExists = true;
			}
		}
		if (!workerExists) {
			worker = new Worker();
		}
		
		// Checking if project exists and if not, creating a new project
		for (Sheet s : wb) {
			String projectName = readProjectName(s);
			Boolean projectExists = false;
			Project project;
			for (Project p : dataModel.projects) {
				if (p.getName().equals(projectName)){
					project = p;
					projectExists = true;
				}
			}
			if (!projectExists) {
				project = new Project();
			}
			
			// Recording tasks for a project
			for (Row r : s) {
				if (r.getRowNum()!=0) {
					Task task = new Task();
					task.setDate(r.getCell(0).getDateCellValue());
					task.setName(r.getCell(1).getStringCellValue());
					task.setTime(r.getCell(3).getNumericCellValue());
					task.setOwner(worker);
					task.setProject(project);
					// Updating tasks under worker and project
					worker.addTask(task);
					project.addTask(task);
				}
			}
		}
	}
	
	public String readFileName(File file) {
		return "Jan Kowalski";
	}
	
	public String readProjectName(Sheet sheet) {
		return "Projekt1";
	}
	
	
}
