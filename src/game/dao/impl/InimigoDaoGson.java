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

import game.dao.InimigoDAO;
import game.dto.InimigoDTO;
import game.entidades.Inimigo;

public class InimigoDaoGson implements InimigoDAO {
	
	public List<Inimigo> burcarPorIdCenario(int id)  {
		List<Inimigo> inimigos = new ArrayList<>();
		for(InimigoDTO i : buscarTodos()) {
			if(i.getIdCenario() == id)
				inimigos.add(new Inimigo(i));
				
		}
		return inimigos;
	}
	
	public List<InimigoDTO> buscarTodos(){
		Gson gson = new GsonBuilder().create();
		Type type = new TypeToken<ArrayList<InimigoDTO>>() {}.getType();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/resouces/cenarios/inimigos.json"));
			return gson.fromJson(br, type);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}