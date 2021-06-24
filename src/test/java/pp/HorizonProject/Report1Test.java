package pp.HorizonProject;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import pp.HorizonProject.DataExtraction.DataModel;
import pp.HorizonProject.DataExtraction.Worker;
import pp.HorizonProject.Reports.Report1;

public class Report1Test {
	
	private static DataModel testDataModel;
	
	@BeforeClass
	public static void setup () {
		
		//	Given
		testDataModel = new DataModelBuilder().build();
	}
	
	
	@Test
    public void Is_workers_reference_equal_to_model() {
	 
		 Report1 report1 = new Report1(testDataModel);
		 
		 Assert.assertEquals(testDataModel.getWorkers(), report1.printReport(2012));
       
    }
	 
	@Test
    public void Is_workers_array_sorted() {
	 
		Report1 report1 = new Report1(testDataModel);
	 
		 ArrayList<Worker> testWorkers = testDataModel.getWorkers();
		 testWorkers.sort((worker1, worker2) -> worker1.getLastName().compareTo(worker2.getLastName()));
		 ArrayList<Worker> reportWorkers = report1.printReport(2012);
	 
		for(int i=0; i < testWorkers.size(); i++) {
			
			Assert.assertEquals(testWorkers.get(i), reportWorkers.get(i));
		}
       
    }
	 
	 

}
