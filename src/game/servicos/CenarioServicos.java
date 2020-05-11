package game.servicos;

import game.dao.CenarioDAO;
import game.dao.DAOFactory;
import game.dto.CenarioDTO;
import game.entidades.Cenario;
import jplay.Window;

public class CenarioServicos {
	
	public CenarioDAO cenarioDAO = DAOFactory.createCenario();
	public InimigoServicos inimigoServicos = new InimigoServicos();
	public JogadorServicos jogadorServicos = new JogadorServicos();
	public LixeiraServicos lixeiraServicos = new LixeiraServicos();
	public ObjetoServicos objetoServicos = new ObjetoServicos();
	public ReciclavelServicos reciclavelServicos = new ReciclavelServicos();
	
	
	public Cenario buscarPorId(int id, Window janela) {
		CenarioDTO c = cenarioDAO.burcarPorIdCenario(id);
		return new Cenario(id, janela, jogadorServicos.burcarPorIdCenario(id), c.getCena(),
				objetoServicos.burcarPorIdCenario(id), inimigoServicos.burcarPorIdCenario(id), 
				lixeiraServicos.burcarPorIdCenario(id));
		
	}
	

}
