package pp.HorizonProject;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import pp.HorizonProject.DataExtraction.DataModel;
import pp.HorizonProject.DataExtraction.Project;
import pp.HorizonProject.Reports.Report2;

public class Report2Test {
	
	private static DataModel testDataModel;
	
	@BeforeClass
	public static void setup () {
		
		//	Given
		testDataModel = new DataModelBuilder().build();
	}
	
	
	@Test
    public void Is_projects_reference_equal_to_model() {
	 
		Report2 report2 = new Report2(testDataModel);
	 
		Assert.assertEquals(testDataModel.getProjects(), report2.printReport(2012));
       
    }
	 
	@Test
    public void Is_projects_array_sorted() {
	 
		Report2 report2 = new Report2(testDataModel);
	 
		 ArrayList<Project> testProjects = testDataModel.getProjects();
		 testProjects.sort((project1, project2) -> project1.getName().compareTo(project2.getName()));
		 ArrayList<Project> reportProjects = report2.printReport(2012);
	 
		for(int i=0; i < testProjects.size(); i++) {
			
			Assert.assertEquals(testProjects.get(i), reportProjects.get(i));
		}
       
    }
	 
	 

}
