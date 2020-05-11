package game.servicos;

import game.dao.JogadorDAO;
import game.dao.impl.JogadorDaoGson;
import game.entidades.Jogador;

public class JogadorServicos {
	
	public JogadorDAO jogadorDAO = new JogadorDaoGson();
		
	public Jogador burcarPorIdCenario(int id) {
		return new Jogador(jogadorDAO.burcarPorIdCenario(id));
	}

}
