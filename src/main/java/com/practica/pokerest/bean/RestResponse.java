package com.practica.pokerest.bean;

import lombok.Data;

@Data
public class RestResponse {

	private String[] messages;
	
	private Pokemon[] result;

}
