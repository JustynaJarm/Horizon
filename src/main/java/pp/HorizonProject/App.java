package pp.HorizonProject;

import java.lang.invoke.SwitchPoint;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;


public class App {
	public static void main(String[] args) throws ParseException {
	Options options = new Options();
	options.addOption("y", false, "Wprowadz rok");
	CommandLineParser parser = new DefaultParser();
	CommandLine cmd = parser.parse( options, args);
	
	if(cmd.hasOption("y")) {
	    System.out.println("test");
	}
	else {
	    // print the date
	}
	
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
