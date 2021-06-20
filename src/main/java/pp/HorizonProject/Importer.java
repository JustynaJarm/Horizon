package pp.HorizonProject;

import java.io.File;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Importer {
	
	public DataModel dataModel = new DataModel();
	
	public void readExactFile(File file) throws Exception {
		Workbook wb = WorkbookFactory.create(file);
		
		// Checking if worker exists and if not, creating a new worker
		String fullName = readFullName(file);
		Worker worker = null;
		for (Worker w : dataModel.workers) {
			if (w.getFullName().equals(fullName)){
				worker = w;
			}
		}
		if (worker==null) {
			worker = new Worker();
			worker.setFullName(fullName);
			worker.setLastName(readLastName(fullName));
			dataModel.workers.add(worker);
		}
		
		// Checking if project exists and if not, creating a new project
		for (Sheet s : wb) {
			String projectName = readProjectName(s);
			Project project = null;
			for (Project p : dataModel.projects) {
				if (p.getName().equals(projectName)){
					project = p;
				}
			}
			if (project == null) {
				project = new Project();
				project.setName(projectName);
				dataModel.projects.add(project);
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
	
	public String readFullName(File file) {
		String nameUnformatted = file.getName();
		// Removing file extension ".xls"
		nameUnformatted = nameUnformatted.substring(0, nameUnformatted.length() - 4);
		// Removing "_"
		String words[] = nameUnformatted.split("_", 2);		
		return words[0] + " " + words[1];
	}
	
	public String readLastName(String fullName) {
		String words[] = fullName.split(" ", 2);		
		return words[1];
	}
	
	public String readProjectName(Sheet sheet) {
		return sheet.getSheetName();
	}
	
	
}
