package game.dao;

import java.util.List;

import game.dto.InimigoDTO;
import game.entidades.Inimigo;

public interface InimigoDAO {
	
	public List<Inimigo> burcarPorIdCenario(int id);
	public List<InimigoDTO> buscarTodos();

}
