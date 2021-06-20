package pp.HorizonProject;

import java.io.File;

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
		
		//read file name and save as Worker
		
		//loop
		//read sheet name and save as Project
			//loop
			//read line and save as task, update worker and project
		
		
	}
	
	public String readFileName(File file) {
		return "Jan Kowalski";
	}
	
	public String readProjectName(Sheet sheet) {
		return "Projekt1";
	}
	
	
}
