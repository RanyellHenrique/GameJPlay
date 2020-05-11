package game.servicos;

import java.util.List;
import java.util.stream.Collectors;

import game.dao.DAOFactory;
import game.dao.InimigoDAO;
import game.entidades.Inimigo;

public class InimigoServicos {
	
	public InimigoDAO inimigoDAO = DAOFactory.createInimigo();
	
	public List<Inimigo> burcarPorIdCenario(int id) {
		return inimigoDAO.burcarPorIdCenario(id).stream().map(o -> new Inimigo(o)).collect(Collectors.toList());
	}

}
