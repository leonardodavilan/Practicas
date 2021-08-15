package com.practica.pokerest.test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.practica.pokerest.bean.Pokemon;
import com.practica.pokerest.util.UtilREST;
import org.springframework.cglib.core.Constants;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
		ResponseEntity<?> response = restTemplate.exchange("https://pokeapi.co/api/v2/pokemon", HttpMethod.GET, httpEntity,Object.class);
		System.out.println("NRESPONSE: " + response);


		String uri="https://pokeapi.co/api/v2/pokemon";
		Gson gson= new Gson();
		Pokemon[] pokemons= gson.fromJson(UtilREST.getREST(uri), Pokemon[].class);

		if (pokemons!=null) {
			
			for (Pokemon post : pokemons) {
				System.out.println(post);
			}
		}
		
	}

}
