package game.dao;

import java.util.List;

import game.dto.ObjetoDTO;

public interface ObjetoDAO {
	
	public List<ObjetoDTO> burcarPorIdCenario(int id);
	public List<ObjetoDTO> buscarTodos();

}
