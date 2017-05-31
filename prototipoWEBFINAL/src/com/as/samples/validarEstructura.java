package com.as.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class validarEstructura {
	public static String id_estructura;
	public String getId() {
	return id_estructura;
}
public void setId(String id) {
	this.id_estructura = id_estructura;
}
	//validacion de la estructura
	public boolean validacion(List<String> al){
		
		/*String listString = "";
		for (String s : al)
		{
		    listString += s;
		}*/
		//System.out.println(listString);
		 MongoClient mongoClient = null;
		 mongoClient = new MongoClient( "localhost" , 27017 );
		 DB db = mongoClient.getDB( "datos" );
		 DBCollection collection = db.getCollection("Estructuras");
		 DBCursor cursor = collection.find();
		
		 while(cursor.hasNext()){//Recorrer la consulta
			 	//System.out.println("campos:");
			 	//System.out.println(cursor.next().get("campos").toString());
			 	DBObject camposCursor = cursor.next();
				 List<String> items = Arrays.asList(camposCursor.get("campos").toString().split("\\s*,\\s*"));
				   if(linearIn(al,items)){
					   this.id_estructura = camposCursor.get("_id").toString();
					   System.out.println("termine validar estructura");
					   return true;
				   }
				 
			 
			// System.out.println("campos:"); 
			//System.out.println(cursor.next().get("campos").toString());
	        }
		
		return false;
	}
	public static boolean linearIn(List<String> al, List<String>estructure) {
		Collections.sort(estructure);
		//System.out.println("validacion estructura:");
		//System.out.println(Arrays.asList(al).containsAll(Arrays.asList(estructure)));
		for(int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i).toString());
        }
		System.out.println("--------");
		/*for(int i = 0; i < estructure.size(); i++) {
            System.out.println(estructure.get(i).toString());
        }*/
		System.out.println("----------------------------------------------------------------");
		return Arrays.asList(al).containsAll(Arrays.asList(estructure));
	}
	static List getKeysFromJson(String json) throws Exception
	{
		Object things = new Gson().fromJson(json, Object.class);
	    List keys = new ArrayList();
	    collectAllTheKeys(keys, things);
	    return keys;
	}
	static void collectAllTheKeys(List keys, Object o)
	{
	    Collection values = null;
	    if (o instanceof Map)
	    {
	    	Map map = (Map) o;
	    	keys.addAll(map.keySet()); // collect keys at current level in hierarchy
	    	values = map.values();
	    }
	    else if (o instanceof Collection)
	    	values = (Collection) o;
	    else // nothing further to collect keys from
	    	return;
	    for (Object value : values)
	    	collectAllTheKeys(keys, value);
	}
}
