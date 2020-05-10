package game.controles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import game.dto.CenarioDTO;
import game.entidades.Cenario;
import game.entidades.Inimigo;
import game.entidades.Jogador;
import game.entidades.Lixeira;
import game.entidades.Objeto;
import jplay.Window;

public class ControleCenario {
	
	public static Cenario cenario(List<CenarioDTO> cenarios, Integer id, Window janela){
		List<Objeto> objetos = new ArrayList<>();
		List<Inimigo> inimigos = new ArrayList<>();
		List<Lixeira> lixeiras = new ArrayList<>();
		Cenario cen;
		for(CenarioDTO cenario : cenarios) {
			if(cenario.getId() == id) {
				cenario.getInimigos().forEach(x -> inimigos.add(new Inimigo(x)));
				cenario.getObjetos().forEach(x -> objetos.add(new Objeto(x)));
				cenario.getLixeiras().forEach(x -> lixeiras.add(new Lixeira(x)));
				cen = (new Cenario(cenario.getId(), janela, new Jogador(cenario.getJogador()),
					cenario.getCena(), objetos, inimigos, lixeiras));
				return cen;
			}
		}
		return null;
	}
	
	public static Cenario novoCenario(Window janela, Integer id) {
		Gson gson = new GsonBuilder().create();
		Type type = new TypeToken<ArrayList<CenarioDTO>>() {}.getType();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/resouces/cenarios/cenarios.json"));
			List<CenarioDTO> cenarios = gson.fromJson(br, type);
			return cenario(cenarios, id, janela);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
