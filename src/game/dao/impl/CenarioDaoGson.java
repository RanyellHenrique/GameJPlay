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

import game.dao.CenarioDAO;
import game.dto.CenarioDTO;

public class CenarioDaoGson implements CenarioDAO {

	public CenarioDTO burcarPorIdCenario(int id)  {
		for(CenarioDTO c : buscarTodos()) {
			if(c.getId() == id)
				return c;
		}
		return null;
	}
	
	public List<CenarioDTO> buscarTodos(){
		Gson gson = new GsonBuilder().create();
		Type type = new TypeToken<ArrayList<CenarioDTO>>() {}.getType();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/resouces/cenarios/cenarios.json"));
			return gson.fromJson(br, type);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
