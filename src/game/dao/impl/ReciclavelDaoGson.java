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

import game.dao.ReciclavelDAO;
import game.dto.ReciclavelDTO;

public class ReciclavelDaoGson implements ReciclavelDAO {
	
	public List<ReciclavelDTO> burcarPorIdCenario(int id)  {
		List<ReciclavelDTO> reciclaveis = new ArrayList<>();
		for(ReciclavelDTO r : buscarTodos()) {
			if(r.getIdCenario() == id)
				reciclaveis.add(r);
				
		}
		return reciclaveis;
	}
	
	public List<ReciclavelDTO> buscarTodos(){
		Gson gson = new GsonBuilder().create();
		Type type = new TypeToken<ArrayList<ReciclavelDTO>>() {}.getType();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/resouces/cenarios/inimigos.json"));
			return gson.fromJson(br, type);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
