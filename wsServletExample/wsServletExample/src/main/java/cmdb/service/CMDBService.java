package cmdb.service;


import cmdb.bean.CMDB;
import cmdb.dao.CMDBDao;
import cmdb.dao.CMDBDaoImpl;

import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;

import javax.servlet.ServletContext;

public class CMDBService {

	private CMDBDao cmdbBDao;
	private ServletContext sctx;
	static CMDBService cmdbService;
	String cmdbBulkDataFile="/WEB-INF/data/cmdb_bulk_data.db.csv";


	public CMDBService(){
		cmdbBDao = new CMDBDaoImpl();

	}

	public boolean populateDataFromFile(){
		if (cmdbBDao.getCmdbList().getCmdbList() == null ||  cmdbBDao.getCmdbList().getCmdbList().isEmpty())
			return cmdbBDao.populateDataFromFile(cmdbBulkDataFile, this.sctx);
		else 
			return false;
	}

	public static CMDBService getCMDBService(){
		if ( null == cmdbService ){
			cmdbService = new CMDBService();
		}
		return cmdbService;

	}
	public static CMDBService getCMDBService(ServletContext sctx){
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
		String noDataFoundText="Error: Data not present for id = " + id;
		CMDB cmdb = cmdbBDao.getDeploymentDetails(id);
		if ( cmdb == null ){
			return this.toXML(noDataFoundText);
		}
		else{
			return this.toXML(cmdb);
		}

	}
	public String getAllDeploymentDetails(){
		return this.toXML(cmdbBDao.getAllDeploymentDetails());

	}
	public ServletContext getSctx() {
		return sctx;
	}

	public void setSctx(ServletContext sctx) {
		this.sctx = sctx;
	}
	public String toXML(Object obj){
		String xml=null;
		try{

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			XMLEncoder encoder=new XMLEncoder(out);
			encoder.writeObject(obj);
			encoder.close();
			xml=out.toString();
		}catch(Exception e){
			e.printStackTrace();

		}
		return xml;

	}
}
