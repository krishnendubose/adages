package cmdb.test;

import cmdb.bean.CMDB;
import cmdb.service.CMDBService;

public class CMDBTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int id =4 ;
		CMDBService cmdbService = null;//CMDBService.getCMDBService();
		System.out.println("All deployment details:- \n" + cmdbService.getAllDeploymentDetails());
		
		System.out.println("Get deployment details for id="+ id +" :- \n" + cmdbService.getDeploymentDetails(id));
		
		System.out.println("Deleting deployment data for id=" + id + ":- \n" + cmdbService.deleteDeploymentDetails(id));
		
		System.out.println("After deletion deployment details:- \n" + cmdbService.getAllDeploymentDetails());
		//Add new data to CMDB list
		CMDB cmdb = new CMDB();
		cmdb.setArtifactName("jboss");
		cmdb.setArtifactVersion("7.8");
		cmdb.setDeployedBy("KB");
		cmdb.setDeploymentDate("01_03_2018");
		cmdb.setDeploymentStatus("Failure");
		cmdb.setId(6);
		//System.out.println("Adding deployment data:- \n" + cmdbService.insertDeploymentDetails(cmdb));
		System.out.println("After addition deployment details:- \n" + cmdbService.getAllDeploymentDetails());
	}

}
