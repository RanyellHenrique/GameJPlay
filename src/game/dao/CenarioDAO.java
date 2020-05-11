package game.dao;

import java.util.List;

import game.dto.CenarioDTO;

public interface CenarioDAO {
	
	public CenarioDTO burcarPorIdCenario(int id);
	public List<CenarioDTO> buscarTodos();

}
