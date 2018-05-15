package cmdb.jersy.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import cmdb.service.CMDBService;


@ApplicationPath("/resourcesCMDB_v1") 
public class RestfulCMDB_v1 extends Application {        
	@Override
	public Set<Class<?>> getClasses() {                
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(CMDBService.class);                         
		return set;
	}
}