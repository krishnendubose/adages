package cmdb.dao;

import javax.servlet.ServletContext;

import cmdb.bean.CMDB;
import cmdb.bean.CMDBList;

public interface CMDBDao {
	String insertDeploymentDetails(CMDB cmdb);
	String updateDeploymentDetails(int id , String artifactName, String artifactVersion, String deploymentStatus);
	String deleteDeploymentDetails(int id);
	CMDB getDeploymentDetails(int id);
	CMDBList getAllDeploymentDetails();
	boolean populateDataFromFile(String cmdbBulkDataFile, ServletContext sctx);
	CMDBList getCmdbList();
}
