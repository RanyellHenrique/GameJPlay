package game.dao;

import java.util.List;

import game.dto.JogadorDTO;

public interface JogadorDAO {
	
	public JogadorDTO burcarPorIdCenario(int id);
	public List<JogadorDTO> buscarTodos();

}
