package cmdb.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;

import cmdb.bean.CMDB;
import cmdb.bean.CMDBList;

public class CMDBDaoImpl implements CMDBDao {

	public CMDBList cmdbList;
	public CMDBDaoImpl(){
		cmdbList=new CMDBList();			
	}

	private CMDB getCMDBByID(int id){
		CMDB cmdb = null;
		for (CMDB data: cmdbList.getCmdbList()){
			if ( id == data.getId()){
				cmdb = data;
				break;
			}
		}
		return cmdb;
	}

	public String insertDeploymentDetails(CMDB cmdb){
		if (true == cmdbList.getCmdbList().add(cmdb) )

			return "Added successfully cmdb= " + cmdb;
		else 
			return "Unable to add cmdb= " + cmdb;
	}

	public String updateDeploymentDetails(int id , String artifactName, String artifactVersion, 
			String deployedBy, String deploymentDate,  String deploymentStatus){
		String updateInfo = "Unable to update as data not found for id = " + id;
		CMDB cmdb = getCMDBByID(id);
		if ( null != cmdb ){
			cmdb.setArtifactName(artifactName);
			cmdb.setArtifactVersion(artifactVersion);
			cmdb.setDeployedBy(deployedBy);
			cmdb.setDeploymentDate(deploymentDate);
			cmdb.setDeploymentStatus(deploymentStatus);
		}
		return updateInfo;

	}

	public String deleteDeploymentDetails(int id){

		String deleteInfo = "Unable to delete as data not found for id = " + id;
		CMDB cmdb = getCMDBByID(id);
		if ( null != cmdb ){
			cmdbList.getCmdbList().remove(cmdb);
			deleteInfo = "Deleted data for id = " + id;				
		}
		return deleteInfo;
	}

	public CMDB getDeploymentDetails(int id){
		return getCMDBByID(id);

	}
	public CMDBList getAllDeploymentDetails(){
		return cmdbList;

	}

	public boolean populateDataFromFile(String cmdbBulkDataFile, ServletContext sctx){		

		BufferedReader br = null;
		InputStream is = sctx.getResourceAsStream(cmdbBulkDataFile);
		String line = "";
		String cvsSplitBy = ",";

		try {
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] dataArr = line.split(cvsSplitBy);       
				if (null != dataArr && dataArr.length == 6){
					CMDB cmdbData = new CMDB();
					cmdbData.setId(Integer.parseInt(dataArr[0]));
					cmdbData.setArtifactName(dataArr[1]);
					cmdbData.setArtifactVersion(dataArr[2]);
					cmdbData.setDeployedBy(dataArr[3]);
					cmdbData.setDeploymentDate(dataArr[4]);
					cmdbData.setDeploymentStatus(dataArr[5]);
					cmdbList.getCmdbList().add(cmdbData);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return false;

	}

}
