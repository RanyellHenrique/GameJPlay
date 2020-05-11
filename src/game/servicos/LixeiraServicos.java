package game.servicos;

import java.util.List;
import java.util.stream.Collectors;

import game.dao.DAOFactory;
import game.dao.LixeiraDAO;
import game.entidades.Lixeira;

public class LixeiraServicos {
	
	public LixeiraDAO lixeiraDAO = DAOFactory.createLixeira();
	
	public List<Lixeira> burcarPorIdCenario(int id) {
		return lixeiraDAO.burcarPorIdCenario(id).stream().map(l -> new Lixeira(l)).collect(Collectors.toList());
	}

}
