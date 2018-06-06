package test.client;

import java.net.URL;
import java.security.cert.Certificate;

import javax.net.ssl.HttpsURLConnection;

public class GoogleClient {
    private static final String endPoint = "https://www.google.com:443/";
	
    public static void main(String[] args) {
		// TODO Auto-generated method stub
       new GoogleClient().doIt();
	}
    
    private void dumpDetails(HttpsURLConnection conn){
    	try{
    		System.out.println("Conn status code:- " + conn.getResponseCode());
    		System.out.println("Cipher suite used:- " + conn.getCipherSuite());
    		Certificate[] certs = conn.getServerCertificates();
    		for (Certificate cert: certs){
    			System.out.println("Whole certificate:- \n"+ cert.toString() + "\n");
    			System.out.println("Cert type:- " + cert.getType());
    			System.out.println("Hash code:- " + cert.hashCode());
    			System.out.println("Algorith used:- "+ cert.getPublicKey().getAlgorithm());
    			System.out.println("Format:- " + cert.getPublicKey().getFormat()+"\n");
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    }
	
	private void doIt(){
		
		try{
			URL url = new URL(endPoint);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setRequestMethod("GET");
			conn.connect();
			dumpDetails(conn);
		}
		catch(Exception e){e.printStackTrace();
		}
		
	}

}
