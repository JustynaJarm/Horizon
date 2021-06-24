package pp.HorizonProject;

import java.util.Scanner;

public class Menu {

	public static final int COLUMN_WIDTH = 80;

	public static void printMenu() {
		String dash = "-";
		System.out.println(dash.repeat(COLUMN_WIDTH));
		System.out.println("| X | Wybierz raport z listy podając nr opcji menu ");
		System.out.println(dash.repeat(COLUMN_WIDTH));
		System.out.println("| 1 | Liczba godzin przepracowanych w danym roku (wg. pracowników)"); // podaj rok
		System.out.println("| 2 | Liczba godzin przepracowanych w danym roku (wg. projektów)"); // podaj rok + projekt
		System.out.println("| 3 | Liczba godzin przepracowanych w danym roku przez danego pracownika"); //podaj rok + pracownika
		System.out.println("| 4 | Procentowe zaangażowanie pracowników w projekty w danym roku"); // podaj rok
		System.out.println("| 5 | Liczba godzin przepracowanych w danym projekcie (wg. pracowników)"); // podaj projekt
		System.out.println("| 6 | Wykres słupkowy: liczba godzin przepracowanych w projektach w danym roku"); // podaj rok
		System.out.println("| 7 | Wykres kołowy: procentowe zaangażowanie pracownika w projekt w danym roku)"); // podaj rok + pracownika
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
				if (year < 2000) System.out.println("Dane dostępne dla lat 2000+");
			} catch (Exception e) {
				System.out.println("Niepoprawne dane! Wprowadź liczbę");
			}
		} while (year < 2000);
		return year;
	}

	public static String getWorkerFromUser() {
		System.out.println("Podaj pracownika do raportu: ");
		try {
			Scanner s = new Scanner(System.in);
			return s.nextLine();

		} catch (Exception e) {
			System.out.println("Niepoprawne dane!");
			return null;
		}
	}
	
	public static String getProjectFromUser() {
		System.out.println("Podaj nazwę projektu do raportu: ");
		try {
			Scanner s = new Scanner(System.in);
			return s.nextLine();

		} catch (Exception e) {
			System.out.println("Niepoprawne dane!");
			return null;
		}
	}
}
