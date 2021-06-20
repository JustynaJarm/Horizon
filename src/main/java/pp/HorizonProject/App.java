package pp.HorizonProject;

import java.io.IOException;
import java.lang.invoke.SwitchPoint;


public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Aktywna ścieżka: " + args[0]);
		
		Importer importer = new Importer();
		importer.readFieles();//args[0]);
		
		
	
		while (true) {
			Menu.printMenu();
			int userInput = Menu.getReportFromUser();
			switch (userInput) {
			case 1:
				System.out.println("Raport1");
				Menu.getYearFromUser();
				Report1 report = new Report1(importer.dataModel);
				report.printReport(2012);
				break;
			case 2:
				System.out.println("Raport2");
				break;
			case 3:
				System.out.println("Raport3");
				break;
			case 4:
				System.out.println("Raport4");
				break;
			case 5:
				System.out.println("Raport5");
				break;
			case 6:
				System.out.println("Raport6");
				break;
			case 7:
				System.out.println("Raport7");
				break;
			case 0:
				System.out.println("Zakonczono");
				System.exit(0);
			default:
				System.out.println("Niepoprawne dane");
			}
		}
	}
}
