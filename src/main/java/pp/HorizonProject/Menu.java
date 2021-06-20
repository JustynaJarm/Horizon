package pp.HorizonProject;

import java.util.Scanner;

public class Menu {
	
public static void printMenu() {
	System.out.println("Aktywna ścieżka: \"C:// ...\"");
	System.out.println("Wybierz raport z listy podając nr opcji menu.");

	System.out.println("Dopisz -xls lub -pdf aby wygenerować raport do pliku Excel lub PDF.");
	System.out.println("Dopisz -year YYYY, -worker Name Surname, -project Project Name aby odpowiednio zawęzić wyniki:");
	
	System.out.println("0. Zakończ program");
	System.out.println("1. Liczba godzin przepracowanych w danym roku (wg. pracowników)");
	System.out.println("2. Liczba godzin przepracowanych w danym roku (wg. projektów)");
	System.out.println("3. Liczba godzin przepracowanych w danym roku przez pracownika");
	System.out.println("4. Procentowe zaangażowanie pracowników w projekty w danym roku");
	System.out.println("5. Liczba godzin przepracowanych w danym projekcie (wg. pracowników)");
	System.out.println("6. Wykres słupkowy liczba godzin przepracowanych w projektach w danym roku");
	System.out.println("7. Wykres kołowy procentowego zaangażowania pracownika w projekt w danym roku);");
}
	
public static int getUserInput()	{
	Scanner s = new Scanner(System.in);
	return s.nextInt();
}
}
