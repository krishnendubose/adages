package cmdb.service;

import cmdb.bean.CMDB;
import cmdb.bean.CMDBList;
import cmdb.dao.CMDBDao;
import cmdb.dao.CMDBDaoImpl;

public class CMDBService {

	CMDBDao cmdbBDao;
	CMDBService cmdbService;
	
	private CMDBService(){
		cmdbBDao = new CMDBDaoImpl();

	}

	public CMDBService getCMDBService(){
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
	public String deleteDeploymentDetails(CMDB cmdb){
		return cmdbBDao.deleteDeploymentDetails(cmdb);

	}
	public CMDB getDeploymentDetails(int id){
		return cmdbBDao.getDeploymentDetails(id);

	}
	public CMDBList getAllDeploymentDetails(){
		return cmdbBDao.getAllDeploymentDetails();

	}
}
