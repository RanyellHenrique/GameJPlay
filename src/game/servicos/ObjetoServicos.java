package game.servicos;

import java.util.List;
import java.util.stream.Collectors;

import game.dao.DAOFactory;
import game.dao.ObjetoDAO;
import game.entidades.Objeto;

public class ObjetoServicos {
	
	public ObjetoDAO objetoDAO = DAOFactory.createObjeto();
	
	public List<Objeto> burcarPorIdCenario(int id) {
		return objetoDAO.burcarPorIdCenario(id).stream().map(o -> new Objeto(o)).collect(Collectors.toList());
	}

}
