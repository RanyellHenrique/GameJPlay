package game.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import game.dao.JogadorDAO;
import game.dto.JogadorDTO;
import game.entidades.Jogador;

public class JogadorDaoGson implements JogadorDAO {
	
	public Jogador burcarPorIdCenario(int id)  {
		for(JogadorDTO j : buscarTodos()) {
			if(j.getIdCenario() == id)
				return new Jogador(j);
		}
		return null;
	}
	
	public List<JogadorDTO> buscarTodos(){
		Gson gson = new GsonBuilder().create();
		Type type = new TypeToken<ArrayList<JogadorDTO>>() {}.getType();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/resouces/cenarios/jogadores.json"));
			return gson.fromJson(br, type);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
