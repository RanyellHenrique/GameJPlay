package game.dao;

import java.util.List;

import game.dto.LixeiraDTO;

public interface LixeiraDAO {
	
	public List<LixeiraDTO> burcarPorIdCenario(int id);
	public List<LixeiraDTO> buscarTodos();

}
