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

import game.dao.ObjetoDAO;
import game.dto.ObjetoDTO;
import game.entidades.Objeto;

public class ObjetoDaoGson implements ObjetoDAO {
	
	public List<Objeto> burcarPorIdCenario(int id)  {
		List<Objeto> objetos = new ArrayList<>();
		for(ObjetoDTO o : buscarTodos()) {
			if(o.getIdCenario() == id)
				objetos.add(new Objeto(o));
				
		}
		return objetos;
	}
	
	public List<ObjetoDTO> buscarTodos(){
		Gson gson = new GsonBuilder().create();
		Type type = new TypeToken<ArrayList<ObjetoDTO>>() {}.getType();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/resouces/cenarios/objetos.json"));
			return gson.fromJson(br, type);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
