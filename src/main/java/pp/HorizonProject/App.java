package pp.HorizonProject;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import pp.HorizonProject.DataExtraction.DataModel;
import pp.HorizonProject.DataExtraction.Importer;
import pp.HorizonProject.Reports.Report1;
import pp.HorizonProject.Reports.Report2;
import pp.HorizonProject.Reports.Report3;


public class App {
	
	public static void main(String[] args) throws IOException {
		int userInput;
		int reportYear;
		String workerName;
		String projectName;
		boolean shouldExport;
		
		// Uwaga do celów testowych nalezy ustawić parametr wywołania w postaci ścieżki do katalogu
		// Run configurations > Arguments > Program Arguments > tu wpisz scieżkę > Apply > Run
		System.out.println("----- Aktywna ścieżka: " + args[0]);
		DataModel dataModel = new DataModel();
		Path rootPath = Paths.get(args[0].toString());
		Importer importer = new Importer(rootPath, dataModel);

		while (true) {
			Menu.printMenu();
			userInput = Menu.getReportFromUser();
			switch (userInput) {
			case 1:
				reportYear = Menu.getYearFromUser();
				Report1 report1 = new Report1(importer.dataModel);
				report1.printReport(reportYear);
				shouldExport = Menu.checkIfShouldExportToExcel();
				if (shouldExport) {
					report1.exportReportDataToExcel("Report1");
				}
				break;
			case 2:
				reportYear = Menu.getYearFromUser();
				Report2 report2 = new Report2(importer.dataModel);
				report2.printReport(reportYear);
				shouldExport = Menu.checkIfShouldExportToExcel();
				if (shouldExport) {
					report2.exportReportDataToExcel("Report2");
				}
				break;
			case 3:
				reportYear = Menu.getYearFromUser();
				workerName = Menu.getWorkerFromUser(dataModel);
				Report3 report3 = new Report3(importer.dataModel);
				report3.printReport(reportYear, workerName);
				shouldExport = Menu.checkIfShouldExportToExcel();
				if (shouldExport) {
					report3.exportReportDataToExcel("Report3");
				}
				break;
			case 4:
				reportYear = Menu.getYearFromUser();
				System.out.println("----- Raport 4 -----");

				break;
			case 5:
				projectName = Menu.getProjectFromUser(dataModel);
				System.out.println("----- Raport 5 -----");

				break;
			case 6:
				reportYear = Menu.getYearFromUser();
				System.out.println(" -----Raport 6 - Wykres słupkowy -----");

				break;
			case 7:
				reportYear = Menu.getYearFromUser();
				workerName = Menu.getWorkerFromUser(dataModel);
				System.out.println("----- Raport 7 - Wykres kołowy -----");

				break;
			case 0:
				System.out.println("Zakończono...");
				System.exit(0);
			default:
				System.out.println("Wybierz opcję od 0 do 7");
			}
		}
	}


}
