package cmdb.dao;

import cmdb.bean.CMDB;
import cmdb.bean.CMDBList;

public interface CMDBDao {
	String insertDeploymentDetails(CMDB cmdb);
	String updateDeploymentDetails(int id , String artifactName, String artifactVersion, String deploymentStatus);
	String deleteDeploymentDetails(int id);
	String getDeploymentDetails(int id);
	String getAllDeploymentDetails();
	boolean populateDataFromFile(String cmdbBulkDataFile);
	String toXML(Object obj);
}
