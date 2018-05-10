package cmdb.bean;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class CMDB implements Serializable {
	
	public AtomicInteger id;
	public String artifactName;
	public String artifactVersion;
	public String deployedBy;
	public String deploymentDate;
    public String deploymentStatus;
    
	public AtomicInteger getId() {
		return id;
	}
	public void setId(AtomicInteger id) {
		this.id = id;
	}
	public String getArtifactName() {
		return artifactName;
	}
	public void setArtifactName(String artifactName) {
		this.artifactName = artifactName;
	}
	public String getArtifactVersion() {
		return artifactVersion;
	}
	public void setArtifactVersion(String artifactVersion) {
		this.artifactVersion = artifactVersion;
	}
	public String getDeployedBy() {
		return deployedBy;
	}
	public void setDeployedBy(String deployedBy) {
		this.deployedBy = deployedBy;
	}
	public String getDeploymentDate() {
		return deploymentDate;
	}
	public void setDeploymentDate(String deploymentDate) {
		this.deploymentDate = deploymentDate;
	}
	public String getDeploymentStatus() {
		return deploymentStatus;
	}
	public void setDeploymentStatus(String deploymentStatus) {
		this.deploymentStatus = deploymentStatus;
	}
}
