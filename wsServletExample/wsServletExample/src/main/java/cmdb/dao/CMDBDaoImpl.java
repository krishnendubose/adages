package cmdb.dao;

import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

	public CMDBList getCmdbList() {
		return cmdbList;
	}
	public void setCmdbList(CMDBList cmdbList) {
		this.cmdbList = cmdbList;
	}
	public String insertDeploymentDetails(CMDB cmdb){
		if (true == cmdbList.getCmdbList().add(cmdb) )

			return "Added successfully cmdb= " + cmdb;
		else 
			return "Unable to add cmdb= " + cmdb;
	}
	public String updateDeploymentDetails(int id , String artifactName, String artifactVersion, String deploymentStatus){
		return "";

	}
	public String deleteDeploymentDetails(int id){

		String deleteInfo = "Unable to delete as data not found for id = " + id;
		for (CMDB data: cmdbList.getCmdbList()){
			if ( id == data.getId()){
				cmdbList.getCmdbList().remove(data);
				deleteInfo = "Deleted data for id = " + id;
				break;
			}
		}

		return deleteInfo;
	}
	public CMDB getDeploymentDetails(int id){
		CMDB cmdb = null;
		for (CMDB data: cmdbList.getCmdbList()){
			if ( id == data.getId()){
				cmdb = data;
				break;
			}
		}
		return cmdb;

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
