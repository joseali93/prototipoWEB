package com.as.samples;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.socrata.api.HttpLowLevel;
import com.socrata.api.Soda2Consumer;
import com.socrata.api.SodaImporter;
import com.socrata.exceptions.LongRunningQueryException;
import com.socrata.exceptions.SodaError;
import com.socrata.model.importer.DatasetInfo;
import com.socrata.model.importer.LicenseInfo;
import com.socrata.model.search.SearchClause;
import com.socrata.model.soql.SoqlQuery;
import com.sun.jersey.api.client.ClientResponse;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JTextField;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;

import com.google.gson.Gson;
import java.util.List;
import java.lang.StringBuilder;

public class Ingreso {
	public Ingreso() {
		// TODO Auto-generated constructor stub
	}
	public String Ingresar(String ids,String domain) throws Exception{
		Soda2Consumer consumer = Soda2Consumer.newConsumer("https://"+domain);
		ClientResponse response = null;
		String retorno = "";
		boolean i = true;
		String payload = "";
		String Tokens = null;
		StringTokenizer tokenizer = new StringTokenizer(ids, ",");
	    while (tokenizer.hasMoreTokens()) {
	    	String token = tokenizer.nextToken();
	    	
	    	try{
	    		
	    		response = consumer.query(token,
	    		HttpLowLevel.JSON_TYPE,
	    		"SELECT * LIMIT 50000");
			    payload = response.getEntity(String.class);
			    MetaData meta = new MetaData();
				List<String> al = new ArrayList<>();
				List keys1 = getKeysFromJson(payload);	
				System.out.println("hola");
				JSONArray jsonarr = new JSONArray(meta.jsonGetRequest(token, null,domain));
				 JSONObject jsonobj2 = jsonarr.getJSONObject(0);
				 JSONArray jsonarr2 = jsonobj2.getJSONArray("columns");
				 System.out.println(jsonarr2.length());
				 for(int j = 0; j < jsonarr2.length(); j++){
					
				    
					JSONObject jsonobj3 = jsonarr2.getJSONObject(j);
				    al.add(jsonobj3.get("fieldName").toString());
				    
				 }
				
				
				
				//Set<String> hs = new HashSet<>();
				//hs.addAll(keys1);
				
			
			
				Collections.sort(al);
				mongoDB insertar = new mongoDB();
				validarEstructura validacion = new validarEstructura();
				//validacion de estructura
				if(validacion.validacion(al)){
					//validacion de si existe
					System.out.println("pase la estructura");
					if(insertar.validacion(token)){
						System.out.println("entre a empezar a ingresar");
						
						insertar.Insertar("contratos",payload,token);
						System.out.println("en medio de ambos");
						validarEstructura valestruc = new validarEstructura();
						insertar.InsertarTokens( meta.jsonGetRequest(token,valestruc.id_estructura,domain),token);
						int res;
				    	res=MetaData.nondiscrimynatory(token);
				    	String resul;
				    	resul=Integer.toString(res);
				    	insertar.InsertarMongoTokens(token, resul);
						retorno += "The dataset "+token+" is inserted<br>";
					}else{
						retorno += "The dataset "+token+" Not inserted because it already exists in the database<br>";
					}
					
					
				}else{
					retorno += "The dataset "+token+" Not inserted because it does not meet any of the following structures "
							+ "<button type=\"button\" class=\"btn btn-info btn-sm\" data-toggle=\"modal\" data-target=\"#myModal\">Ver estructuras</button>"

							+ " <br>";
				}
			}catch(Exception e){
				System.out.println(e);
				
				retorno += "The dataset "+token+" does not exist in "+domain+"<br>";
			}		
	    }
		return retorno;	
	}
	
	static List getKeysFromJson(String json) throws Exception
	{
		Object things = new Gson().fromJson(json.toLowerCase(), Object.class);
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

	final public static String implode(String glue, List<String> array)
	{
	    boolean first = true;
	    StringBuilder str = new StringBuilder();
	    for (String s : array) {
	        if (!first) str.append(glue);
	        str.append(s);
	        first = false;
	    }
	    return str.toString();
	}
}