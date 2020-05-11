package game.dao;

import java.util.List;

import game.dto.InimigoDTO;

public interface InimigoDAO {
	
	public List<InimigoDTO> burcarPorIdCenario(int id);
	public List<InimigoDTO> buscarTodos();

}
