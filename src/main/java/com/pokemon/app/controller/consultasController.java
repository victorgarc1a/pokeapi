package com.pokemon.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pokemon.app.entity.pokemon;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@RestController

public class consultasController {

	private final RestTemplate restTemplate;
	
	@Autowired
	public consultasController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/pokemon/{pokemon}")
	public Object getApi(@PathVariable("pokemon") String pokemon) throws IOException{
		List<Object> arr = new ArrayList<Object>();
		String url = "https://pokeapi-practica.herokuapp.com/pokemon/"+pokemon;
		System.out.println(url);
		System.out.println("si entra "+pokemon);
		Object objeto = restTemplate.getForObject(url, Object.class);
		
		//Object objeto = arr.get(0);
		System.out.println(objeto);
		return objeto;
		
	}
	
}
