package com.practica.pokerest.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class UtilREST {

	public static String getREST(String uri){
				
		try {
			URL url = new URL(uri);
			
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
			System.out.println("Connection:" + connection);
			connection.connect();
			
			return reader(connection);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String getREST(String uri,String user, String psw){
		
		try {
			URL url = new URL(uri);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			String aut=user+":"+psw;
			String autEnc = new String(Base64.getEncoder().encode(aut.getBytes()));
			System.out.println(aut);
			
			connection.setRequestProperty("Authorization", "Basic "+autEnc);

			connection.connect();
			
			return reader(connection);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	private static String reader(HttpURLConnection connection) throws Exception{
		int responseCode = connection.getResponseCode();
		System.out.println("ESTE ES responseCode:"+ responseCode);

		if(responseCode == 200){

			JsonParser jp = new JsonParser();
			JsonElement root = jp.parse(new InputStreamReader((InputStream) connection.getContent()));
			if(root.isJsonObject()){
				JsonObject rootobj = root.getAsJsonObject();
				System.out.println(rootobj.get("results").getAsJsonArray());
				return rootobj.get("results").getAsJsonArray().toString();
			}


		}
		return null;
	}
	
	public static String postREST(String uri,String json) throws IOException {

		URL url = new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
	
		OutputStream os = connection.getOutputStream();
		
		os.write(json.getBytes());
		os.flush();

		if (connection.getResponseCode() != 200) {
			throw new RuntimeException("Error : HTTP error code : "	+ connection.getResponseCode() 
					+ " "+ connection.getResponseMessage());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

		StringBuffer sb=new StringBuffer("");
	    String data="";
		while ((data = br.readLine()) != null) {
			sb.append(data);
		}
		connection.disconnect();
			
		return sb.toString();
	}
	
	
}
