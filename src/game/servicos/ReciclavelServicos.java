package game.servicos;

import java.util.List;
import java.util.stream.Collectors;

import game.dao.DAOFactory;
import game.dao.ReciclavelDAO;
import game.entidades.Reciclavel;

public class ReciclavelServicos {
	
	public ReciclavelDAO reciclavelDAO = DAOFactory.createReciclavel();
	
	public List<Reciclavel> burcarPorIdCenario(int id) {
		return reciclavelDAO.burcarPorIdCenario(id).stream().map(r -> new Reciclavel(r)).collect(Collectors.toList());
	}

}
