package pp.HorizonProject;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Report1Test {
	
	private static DataModel testDataModel;
	
	@BeforeClass
	public static void setup () {
		
		//	Given
		testDataModel = new DataModelBuilder().build();
	}
	
	
	 @Test
	    public void Print_report_from_existing_year() {
		 
		 Report1 report1 = new Report1(testDataModel);
		 report1.printReport();
	       
	    }
	 
	 

}
