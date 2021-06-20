package main.java.pp.HorizonProject;

import java.lang.invoke.SwitchPoint;

public class App {
	public static void main(String[] args) {
		while (true) {
			Menu.printMenu();
			int userInput = Menu.getUserInput();
			switch (userInput) {
			case 1:
				System.out.println("Raport1");
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
