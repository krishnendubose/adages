package cmdb.service;

import javax.servlet.ServletContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
    
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/deployments")
	public String insertDeploymentDetails(@FormParam("id") int id , @FormParam("artifactName") String artifactName, @FormParam("artifactVersion") String artifactVersion, 
			@FormParam("deployedBy") String deployedBy, @FormParam("deploymentDate") String deploymentDate,  @FormParam("deploymentStatus") String deploymentStatus){
		populateDataFromFile();
		return cmdbBDao.insertDeploymentDetails(createCMDB(id , artifactName, artifactVersion, 
				deployedBy, deploymentDate,  deploymentStatus));

	}
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/deployments")
	public String updateDeploymentDetails(@FormParam("id") int id , @FormParam("artifactName") String artifactName, @FormParam("artifactVersion") String artifactVersion, 
			@FormParam("deployedBy") String deployedBy, @FormParam("deploymentDate") String deploymentDate,  @FormParam("deploymentStatus") String deploymentStatus){
		populateDataFromFile();
		return cmdbBDao.updateDeploymentDetails(id , artifactName, artifactVersion, 
				deployedBy, deploymentDate,  deploymentStatus);

	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/deployments/{id: \\d+}")
	public String deleteDeploymentDetails(int id){
		populateDataFromFile();
		return Converter.toJson(cmdbBDao.deleteDeploymentDetails(id));

	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/deployments/{id: \\d+}")
	public String getDeploymentDetails(@PathParam("id") int id){
		populateDataFromFile();
		return Converter.toJson(cmdbBDao.getDeploymentDetails(id));

	}
	
	
	 @GET
	 @Produces({MediaType.APPLICATION_JSON})
	 @Path("/deployments")
	public String getAllDeploymentDetails(){
		populateDataFromFile();
		return Converter.toJson(cmdbBDao.getAllDeploymentDetails());

	}
	 
	private CMDB createCMDB(int id , String artifactName, String artifactVersion, 
			String deployedBy, String deploymentDate,  String deploymentStatus){
		
		CMDB cmdb = new CMDB();
		cmdb.setArtifactName(artifactName);
		cmdb.setArtifactVersion(artifactVersion);
		cmdb.setDeployedBy(deployedBy);
		cmdb.setDeploymentDate(deploymentDate);
		cmdb.setDeploymentStatus(deploymentStatus);
		cmdb.setId(id);
		return cmdb;
	} 
}
