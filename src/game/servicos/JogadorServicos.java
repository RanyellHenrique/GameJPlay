package game.servicos;

import game.dao.DAOFactory;
import game.dao.JogadorDAO;
import game.entidades.Jogador;

public class JogadorServicos {
	
	public JogadorDAO jogadorDAO = DAOFactory.createJogador();
		
	public Jogador burcarPorIdCenario(int id) {
		return new Jogador(jogadorDAO.burcarPorIdCenario(id));
	}

}
