package cmdb.service;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.inject.Singleton;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import cmdb.bean.CMDB;
import cmdb.converter.Converter;
import cmdb.dao.CMDBDao;
import cmdb.dao.CMDBDaoImpl;

@Path("/")
@Singleton
public class CMDBService {

	static CMDBDao cmdbBDao;

	@Context
	private ServletContext sctx;
	
	String cmdbBulkDataFile="/WEB-INF/data/cmdb_bulk_data.db.csv";

	public CMDBService(){
		
		if (null == CMDBService.cmdbBDao){
			cmdbBDao = new CMDBDaoImpl();
		}
	}

	public boolean populateDataFromFile(){
		if (cmdbBDao.getAllDeploymentDetails().getCmdbList() == null 
				||  cmdbBDao.getAllDeploymentDetails().getCmdbList().isEmpty())
			return cmdbBDao.populateDataFromFile(cmdbBulkDataFile, this.sctx);
		else 
			return false;
	}

	public String insertDeploymentDetails(CMDB cmdb){
		populateDataFromFile();
		return cmdbBDao.insertDeploymentDetails(cmdb);

	}
	public String updateDeploymentDetails(int id , String artifactName, String artifactVersion, String deploymentStatus){
		populateDataFromFile();
		return cmdbBDao.updateDeploymentDetails(id, artifactName, artifactVersion, deploymentStatus);

	}
	public String deleteDeploymentDetails(int id){
		populateDataFromFile();
		return cmdbBDao.deleteDeploymentDetails(id);

	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/json/{id: \\d+}")
	public String getDeploymentDetails(@PathParam("id") int id){
		populateDataFromFile();
		return Converter.toJson(cmdbBDao.getDeploymentDetails(id));

	}
	
	
	 @GET
	 @Produces({MediaType.APPLICATION_JSON})
	 @Path("/json")
	public String getAllDeploymentDetails(){
		populateDataFromFile();
		return Converter.toJson(cmdbBDao.getAllDeploymentDetails());

	}
}
