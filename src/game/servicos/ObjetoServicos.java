package game.servicos;

import java.util.List;
import java.util.stream.Collectors;

import game.dao.ObjetoDAO;
import game.dao.impl.ObjetoDaoGson;
import game.entidades.Objeto;

public class ObjetoServicos {
	
	public ObjetoDAO objetoDAO = new ObjetoDaoGson();
	
	public List<Objeto> burcarPorIdCenario(int id) {
		return objetoDAO.burcarPorIdCenario(id).stream().map(o -> new Objeto(o)).collect(Collectors.toList());
	}

}
