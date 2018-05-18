package cmdb.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class SimpleClient {
	
	private static final String baseUrl="http://localhost:8080/wsJerseyExample/resourcesCMDB_v1/deployments";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//new SimpleClient().makeRequest(baseUrl+"/1");
		new SimpleClient().makeRequest(baseUrl);

	}
	
	private void makeRequest(String urlString){
		String response = "";
		try{
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String chunk=null;
			while((chunk = in.readLine()) !=null) {
				response = response + "\n"+ chunk ;
			}
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Response from url " + urlString + " is:- \n" + response);
		
	}

}
