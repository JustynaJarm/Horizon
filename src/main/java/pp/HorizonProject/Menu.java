package pp.HorizonProject;

import java.util.Scanner;

import pp.HorizonProject.DataExtraction.DataModel;
import pp.HorizonProject.DataExtraction.Project;
import pp.HorizonProject.DataExtraction.Worker;

public class Menu {

	public static final int COLUMN_WIDTH = 80;

	public static void printMenu() {
		String dash = "-";
		System.out.println(dash.repeat(COLUMN_WIDTH));
		System.out.println("| X | Wybierz raport z listy podając nr opcji menu ");
		System.out.println(dash.repeat(COLUMN_WIDTH));
		System.out.println("| 1 | Liczba godzin przepracowanych w danym roku (wg. pracowników)"); // podaj rok
		System.out.println("| 2 | Liczba godzin przepracowanych w danym roku (wg. projektów)"); // podaj rok
		System.out.println("| 3 | Liczba godzin przepracowanych w danym roku przez danego pracownika"); // podaj rok + prac
		System.out.println("| 4 | Procentowe zaangażowanie pracowników w projekty w danym roku"); // podaj rok
		System.out.println("| 5 | Liczba godzin przepracowanych w danym projekcie (wg. pracowników)"); // podaj projekt
		System.out.println("| 6 | Wykres słupkowy: liczba godzin przepracowanych w projektach w danym roku"); // podaj rok
		System.out.println("| 7 | Wykres kołowy: procentowe zaangażowanie pracownika w projekt w danym roku)"); // podaj rok + prac
		System.out.println("| 0 | Zakończ program");
		System.out.println(dash.repeat(COLUMN_WIDTH));
	}

	public static int getReportFromUser() {
		try {
			Scanner s = new Scanner(System.in);
			return s.nextInt();

		} catch (Exception e) {
			System.out.println("Niepoprawne dane!");
			return -1;
		}
	}

	public static int getYearFromUser() {
		System.out.println("Podaj rok do raportu: ");
		int year = 0;
		do {
			try {
				Scanner s = new Scanner(System.in);
				year = s.nextInt();
				if (year < 2000)
					System.out.println("Dane dostępne dla lat 2000+");
			} catch (Exception e) {
				System.out.println("Niepoprawne dane! Wprowadź liczbę");
			}
		} while (year < 2000);
		return year;
	}

	// Wymagane pelne imie, format: Kowalski Jan
	public static String getWorkerFromUser(DataModel dataModel) {
		boolean workerNotFound = true;
		String workerName = "";
		System.out.println("Podaj nazwisko i imię pracownika do raportu: ");
		Scanner s = new Scanner(System.in);
		while (workerNotFound) {
			try {
				workerName = s.nextLine();
				for (Worker p : dataModel.getWorkers()) {
					if (workerName.equals(p.getFullName())) {
						System.out.println("Znaleziono pracownika '" + workerName + "'\n");
						workerNotFound = false;
					}
				}
				if (workerNotFound) System.out.println("Pracownik '" + workerName + "' nie istnieje. Wprowadź ponownie");
			} catch (Exception e) {
				System.out.println("Niepoprawne dane! Wprowadź ponownie");
			}
		}
		return workerName;
	}

	public static String getProjectFromUser(DataModel dataModel) {
		boolean projectNotFound = true;
		String projectName = "";
		System.out.println("Podaj nazwę projektu do raportu: ");
		Scanner s = new Scanner(System.in);
		while (projectNotFound) {
			try {
				projectName = s.nextLine();
				for (Project p : dataModel.getProjects()) {
					if (projectName.equals(p.getName())) {
						System.out.println("Znaleziono projekt '" + projectName + "'\n");
						projectNotFound = false;
					}
				}
				if (projectNotFound) System.out.println("Projekt '" + projectName + "' nie istnieje. Wprowadź ponownie");
			} catch (Exception e) {
				System.out.println("Niepoprawne dane! Wprowadź ponownie");
			}
		}
		return projectName;
	}
	
	public static boolean checkIfShouldExportToExcel () {
		Scanner s = new Scanner(System.in);
		boolean shouldExport = false;
		int choice = 0;
		
		System.out.println("Czy wyeksportować dane do excela?");
		System.out.println("1 - tak");
        System.out.println("2 - nie");
        
        try {
            while (true) {
            	choice = s.nextInt();
            	switch (choice) {
            	case 1:
            		return shouldExport = true;
            	case 2:
            		return shouldExport = false;
            	default: 
            		System.out.println("Wybierz opcje 1 (eksportuj) lub 2 (nie eksportuj)");
            	}
            }
        } catch (Exception e) {
        	System.out.println("Niepoprawne dane! Wprowadź ponownie");
        }

        return shouldExport;
	}
}
