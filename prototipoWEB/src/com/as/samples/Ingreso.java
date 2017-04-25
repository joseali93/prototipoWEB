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
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import java.util.List;
import java.lang.StringBuilder;

public class Ingreso {
	List<String> structureOne = Arrays.asList(
			"codigo_contrato", 
			"codigo_del_proyecto", 
			"disponibilidades_presupuestales", 
			"evento", 
			"fecha_inicio", 
			"fecha_suscripcion", 
			"identificacion_contratista", 
			"identificacion_interventor", 
			"no_contrato_interventor", 
			"nombre_contratista", 
			"nombre_del_interventor", 
			"nombre_del_proyecto", 
			"objeto_del_contrato", 
			"plazo_estimado", 
			"proceso_de_contratacion", 
			"registros_presupuestales", 
			"sector_del_proyecto", 
			"sujeto_de_control", 
			"tipo_de_registro", 
			"tipo_interventor", 
			"tipologia", 
			"valor_contrato", 
			"valor_del_proyecto", 
			"valor_ejecutado_del_proyecto");
	List<String> structureTwo= Arrays.asList(
			 "c_digo_contrato",
			 "c_digo_del_proyecto",
			 "disponibilidades_presupuestales",
			 "evento",
			 "fecha_inicio",
			 "fecha_suscripci_n",
			 "identificaci_n_contratista",
			 "identificaci_ninterventor",
			 "no_contrato_interventor",
			 "nombre_del_interventor",
			 "nombre_delproyecto",
			 "nombrecontratista",
			 "objeto_del_contrato",
			 "plazo_estimado",
			 "proceso_de_contrataci_n",
			 "registros_presupuestales",
			 "sector_del_proyecto",
			 "sujeto_de_control",
			 "tipo_de_registro",
			 "tipo_interventor",
			 "tipolog_a",
			 "valor_contrato",
			 "valor_delproyecto",
			 "valor_ejecutadodel_proyecto");
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
	    		"SELECT * LIMIT 20000");
			    payload = response.getEntity(String.class);
				List keys1 = getKeysFromJson(payload);	
				List<String> al = new ArrayList<>();
				Set<String> hs = new HashSet<>();
				hs.addAll(keys1);
				al.clear();
				al.addAll(hs);
				Collections.sort(al);
				mongoDB insertar = new mongoDB();
				System.out.println("prueba2");
				if(linearIn(al,structureOne) || linearIn(al,structureTwo)){
					
					if(insertar.validacion(token)){
						MetaData meta = new MetaData();
						insertar.Insertar("contratos",payload,token);
						insertar.Insertar("Tokens", meta.jsonGetRequest(token),token);
						int res;
				    	res=MetaData.nondiscrimynatory(token);
				    	String resul;
				    	resul=Integer.toString(res);
				    	insertar.InsertarMongoTokens(token, resul);
						retorno += "El conjunto de datos "+token+" se inserto<br>";
						
					}else{
						
						retorno += "El conjunto de datos "+token+" no se inserto porque ya existe en la base de datos<br>";
					}
					
					
				}else{
					retorno += "El conjunto de datos "+token+" no se inserto porque no cumple con la siguiente estuctura ["+implode(", ",structureOne)+"] <br>";
				}
			}catch(Exception e){
				retorno += "El conjunto de datos "+token+" no existe en "+domain+"<br>";
			}		
	    }
		return retorno;	
	}
	public static boolean linearIn(List<String> al, List<String>estructure) {
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
	private static void borrarArchivo(String direccion) {
		File directorio = new File(direccion);
	    File f;
	    if (directorio.isDirectory()) {
	    	String[] files = directorio.list();
	        if (files.length > 0) {
	        	System.out.println(" Directorio vacio: " + direccion);
	            for (String archivo : files) {
	            	System.out.println(archivo);
	                f = new File(direccion + File.separator + archivo);
	                f.delete();
	                f.deleteOnExit();
	            }
	        }
	    }
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