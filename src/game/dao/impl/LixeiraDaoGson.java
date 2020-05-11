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

import game.dao.LixeiraDAO;
import game.dto.LixeiraDTO;

public class LixeiraDaoGson implements LixeiraDAO {
	
	public List<LixeiraDTO> burcarPorIdCenario(int id)  {
		List<LixeiraDTO> lixeiras = new ArrayList<>();
		for(LixeiraDTO l : buscarTodos()) {
			if(l.getIdCenario() == id)
				lixeiras.add(l);
		}
		return lixeiras;
	}
	
	public List<LixeiraDTO> buscarTodos(){
		Gson gson = new GsonBuilder().create();
		Type type = new TypeToken<ArrayList<LixeiraDTO>>() {}.getType();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/resouces/cenarios/lixeiras.json"));
			return gson.fromJson(br, type);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
