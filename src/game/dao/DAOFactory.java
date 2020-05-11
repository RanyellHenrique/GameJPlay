package game.dao;

import game.dao.impl.CenarioDaoGson;
import game.dao.impl.InimigoDaoGson;
import game.dao.impl.JogadorDaoGson;
import game.dao.impl.LixeiraDaoGson;
import game.dao.impl.ObjetoDaoGson;
import game.dao.impl.ReciclavelDaoGson;

public class DAOFactory {
	
	public static CenarioDAO createCenario() {
		return new CenarioDaoGson();
	}
	
	public static InimigoDAO createInimigo() {
		return new InimigoDaoGson();
	}
	
	public static JogadorDAO createJogador() {
		return new JogadorDaoGson();
	}
	
	public static LixeiraDAO createLixeira() {
		return new LixeiraDaoGson();
	}
	
	public static ObjetoDAO createObjeto() {
		return new ObjetoDaoGson();
	}
	
	public static ReciclavelDAO createReciclavel() {
		return new ReciclavelDaoGson();
	}
}
