package cmdb.dao;

import cmdb.bean.CMDB;
import cmdb.bean.CMDBList;

public class CMDBDaoImpl implements CMDBDao {
	public String insertDeploymentDetails(CMDB cmdb){
		return "";
		
	}
	public String updateDeploymentDetails(int id , String artifactName, String artifactVersion, String deploymentStatus){
		return "";
		
	}
	public String deleteDeploymentDetails(CMDB cmdb){
		return "";
		
	}
	public CMDB getDeploymentDetails(int id){
		return new CMDB();
		
	}
	public CMDBList getAllDeploymentDetails(){
		return new CMDBList();
		
	}
}
