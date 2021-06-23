package pp.HorizonProject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Importer {
	
	public DataModel dataModel = new DataModel();
	
	
	 public static void main( String[] args ) throws EncryptedDocumentException, IOException
	    {
	        System.out.println( "Hello World!" );
	        
//	        Importer imp = new Importer();
//	        imp.readExactFile(new File("C:\\Users\\harych\\Desktop\\reporter-dane\\reporter-dane\\2012\\01\\Kowalski_Jan.xls"));
//	        for (Task t : imp.dataModel.tasks) {
//	        	System.out.println(t.getDate());
//	        	System.out.println(t.getName());
//	        	System.out.println(t.getTime());
//	        }
	        
	        Importer importer = new Importer();
	        importer.readFieles();

	    }
	 
	 public Importer() throws IOException {
		 readFieles();
	 }
	
	
	public  void readFieles() throws IOException {
		
		Path rootPath = Paths.get("C:\\Users\\harych\\Desktop\\reporter-dane\\reporter-dane");
		List<Object> paths = findByFileExtension(rootPath, ".xls");
		 
		for (Object item : paths) {
			
			String itemAsString = item.toString();
			File file = new File(itemAsString);
			System.out.println(item);
			readExactFile(file);
			
	         
	      }
		
	}
	
	
	public void readExactFile(File file) throws EncryptedDocumentException, IOException {

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
					try {
						Task task = new Task();
						task.setDate(r.getCell(0).getDateCellValue());
						task.setName(r.getCell(1).getStringCellValue());
						if (r.getCell(2).getNumericCellValue() < 0){
							throw new Exception();
						} else {
							task.setTime(r.getCell(2).getNumericCellValue());
						}
						task.setOwner(worker);
						task.setProject(project);
						// Updating tasks under worker and project
						worker.tasks.add(task);
						project.tasks.add(task);
						dataModel.tasks.add(task);
						System.out.println(worker.getFullName() + " " + task.getDate() + " " + task.getTime() + " " + task.getProject().getName() + " " + task.getName());
						
					} catch (Exception e) {
						System.out.println("Niepoprawne dane w pliku wejściowym: " + file.getName());
						System.out.println("Wiersz numer " + r.getRowNum() + " został pominięty");
					}
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
	
	 public static List<Object> findByFileExtension(Path path, String fileExtension) throws IOException {

	        if (!Files.isDirectory(path)) {
	            throw new IllegalArgumentException("Path must be a directory!");
	        }

	        List<Object> result;
	        try (Stream<Path> walk = Files.walk(path)) {
	            result = walk
	                    .filter(Files::isRegularFile)   // is a file
	                    .filter(p -> p.getFileName().toString().endsWith(fileExtension))
	                    .collect(Collectors.toList());
	        }
	        return result;

	    }
	
	
}
