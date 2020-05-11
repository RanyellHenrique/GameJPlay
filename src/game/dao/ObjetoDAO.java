package game.dao;

import java.util.List;

import game.dto.ObjetoDTO;
import game.entidades.Objeto;

public interface ObjetoDAO {
	
	public List<Objeto> burcarPorIdCenario(int id);
	public List<ObjetoDTO> buscarTodos();

}
