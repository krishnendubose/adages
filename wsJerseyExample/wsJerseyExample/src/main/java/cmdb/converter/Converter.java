package cmdb.converter;

import com.fasterxml.jackson.databind.ObjectMapper;

import cmdb.bean.CMDB;
import cmdb.bean.CMDBList;

public class Converter {

	public static String toJson(CMDB cmdb){

		String json = "If you see this, there's a problem.";
		try {
			json = new ObjectMapper().writeValueAsString(cmdb);
		}
		catch(Exception e) { }
		return json;
	}

	public static String toJson(CMDBList cmdbList){

		String json = "If you see this, there's a problem.";
		try {
			
			json = new ObjectMapper().writeValueAsString(cmdbList);
		}
		catch(Exception e) { }
		return json;
	}
	
	public static String toJson(String msg){

		String json = "If you see this, there's a problem.";
		try {
			
			json = new ObjectMapper().writeValueAsString(msg);
		}
		catch(Exception e) { }
		return json;
	}


}
