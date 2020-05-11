package game.servicos;

import java.util.List;
import java.util.stream.Collectors;

import game.dao.LixeiraDAO;
import game.dao.impl.LixeiraDaoGson;
import game.entidades.Lixeira;

public class LixeiraServicos {
	
	public LixeiraDAO lixeiraDAO = new LixeiraDaoGson();
	
	public List<Lixeira> burcarPorIdCenario(int id) {
		return lixeiraDAO.burcarPorIdCenario(id).stream().map(l -> new Lixeira(l)).collect(Collectors.toList());
	}

}
