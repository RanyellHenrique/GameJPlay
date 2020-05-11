package game.dao;

import java.util.List;

import game.dto.ReciclavelDTO;

public interface ReciclavelDAO {
	
	public List<ReciclavelDTO> burcarPorIdCenario(int id);
	public List<ReciclavelDTO> buscarTodos();

}
