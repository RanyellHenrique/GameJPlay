package game.servicos;

import java.util.List;
import java.util.stream.Collectors;

import game.dao.InimigoDAO;
import game.dao.impl.InimigoDaoGson;
import game.entidades.Inimigo;

public class InimigoServicos {
	
	public InimigoDAO inimigoDAO = new InimigoDaoGson();
	
	public List<Inimigo> burcarPorIdCenario(int id) {
		return inimigoDAO.burcarPorIdCenario(id).stream().map(o -> new Inimigo(o)).collect(Collectors.toList());
	}

}
