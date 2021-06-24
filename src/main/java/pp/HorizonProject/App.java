package pp.HorizonProject;

import java.io.IOException;
import java.lang.invoke.SwitchPoint;


public class App {
	public static void main(String[] args) throws IOException {
//		System.out.println("Aktywna ścieżka: " + args[0]);
		
		Importer importer = new Importer();
		importer.readFieles();//args[0]);
		
		
	
		while (true) {
			Menu.printMenu();
			int userInput = Menu.getReportFromUser();
			switch (userInput) {
			case 1:
//				Menu.getYearFromUser();
				Report1 report1 = new Report1(importer.dataModel);
				report1.printReport(2012);
				break;
			case 2:
				Report2 report2 = new Report2(importer.dataModel);
				report2.printReport(2012);
				break;
			case 3:
				Report3 report3 = new Report3(importer.dataModel);
				report3.printReport(2012, "Kowalski Jan");
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
