package pp.HorizonProject;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import pp.HorizonProject.DataExtraction.DataModel;
import pp.HorizonProject.Reports.Report3;

public class Report3Test {
	
	private static DataModel testDataModel;
	
	@BeforeClass
	public static void setup () {
		
		//	Given
		testDataModel = new DataModelBuilder().build();
	}
	
	
	 @Test
	 public void Is_correct_worker_found_1() {
		 
		 Report3 report3 = new Report3(testDataModel);
	 
		 Assert.assertEquals("Kowalski Jan", report3.findWorker("Kowalski Jan", testDataModel.getWorkers())
				 .getFullName());
	 }
	 
	 @Test
	 public void Is_correct_worker_found_2() {
		 
		 Report3 report3 = new Report3(testDataModel);
	 
		 Assert.assertEquals("Nowak Piotr", report3.findWorker("Nowak Piotr", testDataModel.getWorkers())
				 .getFullName());
	 }
	 
	
	 
	 
}
