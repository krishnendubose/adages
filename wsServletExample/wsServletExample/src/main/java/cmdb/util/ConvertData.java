package cmdb.util;

import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class ConvertData {

	public static String toXML(Object obj){
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
	public static String toJSON(String payload){
		JSONObject jobt;
		try {
			jobt = XML.toJSONObject(payload);
			payload = jobt.toString(3);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return payload;
	}
	
}
