package pp.HorizonProject;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Report2Test {
	
	private static DataModel testDataModel;
	
	@BeforeClass
	public static void setup () {
		
		//	Given
		testDataModel = new DataModelBuilder().build();
	}
	
	
	 @Test
	    public void Print_report_from_existing_year() {
		 
		 Report2 report2 = new Report2(testDataModel);
		 report2.printReport();
	       
	    }
	 
	 

}
