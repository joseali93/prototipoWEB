package com.as.samples;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.MarshalException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import com.socrata.api.HttpLowLevel;
import com.socrata.api.Soda2Consumer;
import com.socrata.exceptions.LongRunningQueryException;
import com.socrata.exceptions.SodaError;
import com.sun.jersey.api.client.ClientResponse;
public class mongoDB {

	public mongoDB()  {
		// TODO Auto-generated constructor stub
	}
	public void Insertar(String collectionDB, String json,String token) throws JSONException{
		 System.out.println("entre a insertar datos..."+token);
		 MongoClient mongoClient = null;
		 mongoClient = new MongoClient( "localhost" , 27017 );
		 DB db = mongoClient.getDB( "datos" );
		 DBCollection collection = db.getCollection(collectionDB);
		 JSONArray jsonarr = new JSONArray(json);
		 for(int i = 0; i < jsonarr.length(); i++){
		 	JSONObject jsonobj = jsonarr.getJSONObject(i);
		 	jsonobj.put("cantidadComplt", jsonobj.length());
		 	jsonobj.put("idrepositorio", token);
		 	DBObject dbObject = (DBObject)JSON.parse(jsonobj.toString());
		    collection.insert(dbObject);
		 }
		 System.out.println("termine de ingresar datos en contratos: "+token);
	}
	
	
		public void InsertarTokens(String json,String token) throws IOException, JSONException{
			 MongoClient mongoClient = null;
			 mongoClient = new MongoClient( "localhost" , 27017 );
			 DB db = mongoClient.getDB( "datos" );
			 DBCollection collection = db.getCollection("Tokens");
			 JSONArray jsonarr = new JSONArray(json);
			 for(int i = 0; i < jsonarr.length(); i++){
				 JSONObject jsonobj2 = jsonarr.getJSONObject(i);
			    jsonobj2.put("standard", db.eval("columnasCompletas()"));
			    System.out.println(jsonobj2.toString());
			    DBObject dbObject = (DBObject)JSON.parse(jsonobj2.toString());
			 	collection.insert(dbObject);
			 }
			System.out.println("ingrese los tokensitos");
		}
	public void InsertarMongoTokens(String Tokens,String valor) throws IOException, JSONException{
		MongoClient mongoClient = null;
		mongoClient = new MongoClient( "localhost" , 27017 );
		DB db = mongoClient.getDB( "datos" );
		DBCollection collection = db.getCollection("principio");
		BasicDBObject doc = new BasicDBObject();
		doc.put("Numero_Token", Tokens);
		doc.put("Numero", valor);
		collection.insert(doc);
}
	static String readFile(String path, Charset encoding) throws IOException 
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
	
	
	
	static boolean validacion(String token){
		System.out.println("entre a validacion");
		 MongoClient mongoClient = null;
		 mongoClient = new MongoClient( "localhost" , 27017 );
		 DB db = mongoClient.getDB( "datos" );
		 DBCollection collection = db.getCollection("Tokens");
		

		
		 BasicDBObject whereQuery = new BasicDBObject();
		 whereQuery.put("id",token);
		 int cursor = collection.find(whereQuery).count();
	
		 if(cursor>0){
			 
			 return false;
		 }else{
			 
			 return true;
		 }
		
		
		
	}
	public String consultaids(){
		MongoClient mongoClient = null;
		BasicDBObject resultadoconsulta = null;
		String mensaje = "";
		String mensaje2 = ""; 
		String mensaje3 = "";
		String link = "";
		//Conexion con mogo
		mongoClient = new MongoClient( "localhost" , 27017 );
		DB db = mongoClient.getDB( "datos" ); //Selecciona base de datos
		DBCollection collection = db.getCollection("Tokens"); //Selecciona la coleccion
        //DBCursor iterable = db.getCollection("contratos").find(new BasicDBObject("disponibilidades_presupuestales", id));
        //DBCursor iterable = db.getCollection("contratos").find();
        DBCursor iterable = collection.find();
        mensaje = "<table class='table'> <tr> <th> Nombre set </th> <th> Token </th> </tr> ";
        while(iterable.hasNext()){//Recorreo la consulta
        	resultadoconsulta = new BasicDBObject((Map) iterable.next());
            link = resultadoconsulta.get("name").toString().replace(' ', '-');
            mensaje2 = mensaje2 + " <tr> <td> " + resultadoconsulta.get("name") + " </td> <td> <a href='https://www.datos.gov.co/Organismos-de-Control" +"/" +  link + "/" + resultadoconsulta.get("id") +" ' target='_blank'>  " + resultadoconsulta.get("id") + " </a> </td> </tr> ";
			//}
        	
        }
		return mensaje3 = mensaje + mensaje2 + " </table>";
	}
	
	//inserta la estructura y el numero de campos
	public void insertarEstructura(String id,String domain) throws Exception{
		
		MongoClient mongoClient = null;
		mongoClient = new MongoClient( "localhost" , 27017 );
		DB db = mongoClient.getDB( "datos" );
		DBCollection collection = db.getCollection("Estructuras");
		/*BasicDBObject doc = new BasicDBObject();
		//doc.put("campos", campos.toLowerCase());
		
		//StringTokenizer tokenizer = new StringTokenizer(campos, ",");
		
	    int i = 0;
	    Soda2Consumer consumer = Soda2Consumer.newConsumer("https://"+domain);
		ClientResponse response = null;
		response = consumer.query(id,
	    		HttpLowLevel.JSON_TYPE,
	    		"SELECT * LIMIT 2000");
		String payload = response.getEntity(String.class);
		validarEstructura obtenerLLaves =  new validarEstructura();
		
		List keys1 = obtenerLLaves.getKeysFromJson(payload);
		
		System.out.println("json:");
		
		
		List<String> al = new ArrayList<>();
		Set<String> hs = new HashSet<>();
		hs.addAll(keys1);
		al.clear();
		al.addAll(hs);
		Collections.sort(al);*/
		MetaData meta = new MetaData();
		List<String> al = new ArrayList<>();
		 JSONArray jsonarr = new JSONArray(meta.jsonGetRequest(id, null,domain));
		 JSONObject jsonobj2 = jsonarr.getJSONObject(0);
		 JSONArray jsonarr2 = jsonobj2.getJSONArray("columns");
		 System.out.println(jsonarr2.length());
		 for(int i = 0; i < jsonarr2.length(); i++){
			
		    
			JSONObject jsonobj3 = jsonarr2.getJSONObject(i);
		    al.add(jsonobj3.get("fieldName").toString());
		    
		 }
		
		
		
		//Set<String> hs = new HashSet<>();
		//hs.addAll(keys1);
		
	
	
		Collections.sort(al);
		String json = "{\"campos\":\""+al.toString().replace("[", "").replace("]","").replaceAll("\\s","")+"\",\"cantidad\":\""+al.size()+"\"}";
		
		
		
		
		
		
		DBObject dbObject = (DBObject)JSON.parse(json);
		
		
		
		collection.insert(dbObject);
		
	}
}