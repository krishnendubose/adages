package cmdb.service;

import cmdb.bean.CMDB;
import cmdb.bean.CMDBList;
import cmdb.dao.CMDBDao;
import cmdb.dao.CMDBDaoImpl;

public class CMDBService {

	CMDBDao cmdbBDao;
	static CMDBService cmdbService;
	String cmdbBulkDataFile="/home/krishnendu/Documents/Development/projects/adages/cmdb/src/cmdb/resources/cmdb_bulk_data.db.csv";
	
	private CMDBService(){
		cmdbBDao = new CMDBDaoImpl();
		cmdbBDao.populateDataFromFile(cmdbBulkDataFile);
	}

	public static CMDBService getCMDBService(){
		if ( null == cmdbService ){
			cmdbService = new CMDBService();
		}
		return cmdbService;

	}

	public String insertDeploymentDetails(CMDB cmdb){
		return cmdbBDao.insertDeploymentDetails(cmdb);

	}
	public String updateDeploymentDetails(int id , String artifactName, String artifactVersion, String deploymentStatus){
		return cmdbBDao.updateDeploymentDetails(id, artifactName, artifactVersion, deploymentStatus);

	}
	public String deleteDeploymentDetails(int id){
		return cmdbBDao.deleteDeploymentDetails(id);

	}
	public String getDeploymentDetails(int id){
		return cmdbBDao.getDeploymentDetails(id);

	}
	public String getAllDeploymentDetails(){
		return cmdbBDao.getAllDeploymentDetails();

	}
}
