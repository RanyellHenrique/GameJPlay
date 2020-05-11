package game.dao;

import java.util.List;

import game.dto.JogadorDTO;
import game.entidades.Jogador;

public interface JogadorDAO {
	
	public Jogador burcarPorIdCenario(int id);
	public List<JogadorDTO> buscarTodos();

}
