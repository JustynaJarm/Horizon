package pp.HorizonProject;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DataModelBuilder {
	
	private DataModel testDataModel = new DataModel();
	private Path testRootPath = Paths.get("src//test//test_data");
	private Importer testImporter = new Importer(testRootPath, testDataModel);
	
	
	public DataModel build() {
		
		return this.testDataModel;
	}

}
