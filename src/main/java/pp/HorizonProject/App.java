package pp.HorizonProject;

import java.io.IOException;
import java.lang.invoke.SwitchPoint;

public class App {
	
	public static void main(String[] args) throws IOException {
		int userInput;
		int reportYear;
		String workerName;
		String projectName;

		System.out.println("Aktywna ścieżka: " + args[0]);
		Importer importer = new Importer();
		// importer.readFieles();//args[0]);

		while (true) {
			Menu.printMenu();
			userInput = Menu.getReportFromUser();
			switch (userInput) {
			case 1:
				reportYear = Menu.getYearFromUser();
				System.out.println("Raport 1");
				Report1 report = new Report1(importer.dataModel);
				report.printReport(reportYear);
				break;
			case 2:
				reportYear = Menu.getYearFromUser();
				projectName = Menu.getProjectFromUser();
				System.out.println("Raport 2");

				break;
			case 3:
				reportYear = Menu.getYearFromUser();
				workerName = Menu.getWorkerFromUser();
				System.out.println("Raport 3");

				break;
			case 4:
				reportYear = Menu.getYearFromUser();
				System.out.println("Raport 4");

				break;
			case 5:
				projectName = Menu.getProjectFromUser();
				System.out.println("Raport 5");

				break;
			case 6:
				reportYear = Menu.getYearFromUser();
				System.out.println("Raport 6 - Wykres słupkowy");

				break;
			case 7:
				reportYear = Menu.getYearFromUser();
				workerName = Menu.getWorkerFromUser();
				System.out.println("Raport 7 - Wykres kołowy");

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
