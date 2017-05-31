package com.as.samples;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.json.JSONException;
import org.json.JSONObject;
public class MetaData {

	public MetaData() {
		// TODO Auto-generated constructor stub
	}
	private static String streamToString(InputStream inputStream) throws IOException {
		StringWriter writer = new StringWriter();
		IOUtils.copy(inputStream, writer, "UTF-8");
		String theString = writer.toString();
		 
		 //String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
		
		 return theString;
		}

		public static String jsonGetRequest(String token,String id_estructura,String domain) throws JSONException {
			//String  urlQueryString ="https://www.datos.gov.co/api/views/"+token+"/rows.json?accessType=DOWNLOAD";
			String  urlQueryString ="https://"+domain+"/api/views/"+token;
			
		 String json = null;
		 ObjectNode node = null;
		 String meta= null;
		 try {
		   URL url = new URL(urlQueryString);
		   HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		   connection.setDoOutput(true);
		   connection.setInstanceFollowRedirects(false);
		   connection.setRequestMethod("GET");
		   connection.setConnectTimeout(5000); // 5 sec
		   connection.setReadTimeout(10000); // 10 sec
		   connection.setRequestProperty("Content-Type", "application/json");
		   connection.setRequestProperty("charset", "utf-8");
		   
		   connection.connect();
		  
		   InputStream inStream = connection.getInputStream();
		   
		   json = streamToString(inStream); // input stream to string
		  
		   JSONObject object = new JSONObject(json);
		   if(id_estructura!=null){object.put("idestructura", id_estructura);}
		   
		   object.put("id", token);
		   meta = "["+object+"]";


		   
		   
		 } catch (IOException ex) {
		   ex.printStackTrace();
		 }
		 return meta;

		}
		public static int nondiscrimynatory(String token) throws JSONException {
			int error=0;
			int er=0;
			for(int i=1;i<10;i++){
				String  urlQueryString ="https://www.datos.gov.co/api/views/"+token+"/rows.json?accessType=DOWNLOAD";
				 int json = 0;
				 ObjectNode node = null;
				 String meta= null;
				 
				 try {
				   URL url = new URL(urlQueryString);
				   HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				   connection.setDoOutput(true);
				   connection.setInstanceFollowRedirects(false);
				   connection.setRequestMethod("GET");
				   connection.setRequestProperty("Content-Type", "application/json");
				   connection.setRequestProperty("charset", "utf-8");
				   connection.connect();
				   json=connection.getResponseCode();
				   //InputStream inStream = connection.getInputStream();
				   //json = streamToString(inStream);
				   if(json==200){
						error=error+1;
					}else{
						System.out.println(json);;
					}
				 } catch (IOException ex) {
					   ex.printStackTrace(); 
					 }
				
				
			}
			
			return error;
		}
}
