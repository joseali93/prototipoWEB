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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
public class mongoDB {

	public mongoDB()  {
		// TODO Auto-generated constructor stub
	}
	public void Insertar(String collectionDB, String json,String token) throws JSONException{
		 MongoClient mongoClient = null;
		 mongoClient = new MongoClient( "localhost" , 27017 );
		 DB db = mongoClient.getDB( "datos" );
		 DBCollection collection = db.getCollection(collectionDB);
		 JSONArray jsonarr = new JSONArray(json);
		 
		 for(int i = 0; i < jsonarr.length(); i++){
		 	 JSONObject jsonobj = jsonarr.getJSONObject(i);
		 	jsonobj.put("id", token);
		    if(collectionDB=="Tokens"){
		    	jsonobj.put("standard", db.eval("columnasCompletas()"));
		    	DBObject dbObject = (DBObject)JSON.parse(jsonobj.toString());
		 	    collection.insert(dbObject);
		    } else {
		    	DBObject dbObject = (DBObject)JSON.parse(jsonobj.toString());
		 	    collection.insert(dbObject);
		    }
		 }
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
		
		 MongoClient mongoClient = null;
		 mongoClient = new MongoClient( "localhost" , 27017 );
		 DB db = mongoClient.getDB( "datos" );
		 DBCollection collection = db.getCollection("Tokens");
		

		
		 BasicDBObject whereQuery = new BasicDBObject();
		 whereQuery.put("id",token);
		 int cursor = collection.find(whereQuery).count();
		 System.out.println("hola");
		 if(cursor>0){
			 
			 return false;
		 }else{
			 
			 return true;
		 }
		
		
		
	}
}