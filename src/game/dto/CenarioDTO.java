package game.dto;

import java.util.ArrayList;
import java.util.List;

public class CenarioDTO {
	
	private Integer id;
	private String cena;
	private JogadorDTO jogador;
	private List<InimigoDTO> inimigos = new ArrayList<>();
	private List<ObjetoDTO> objetos = new ArrayList<>();
	private List<ReciclavelDTO> reciclaveis = new ArrayList<>();
	private List<LixeiraDTO> lixeiras = new ArrayList<>();
	
	public CenarioDTO(Integer id, String cena, JogadorDTO jogador, List<InimigoDTO> inimigos, List<ObjetoDTO> objetos,
			List<ReciclavelDTO> reciclaveis, List<LixeiraDTO> lixeiras) {
		this.id = id;
		this.cena = cena;
		this.jogador = jogador;
		this.inimigos = inimigos;
		this.objetos = objetos;
		this.reciclaveis = reciclaveis;
		this.lixeiras = lixeiras;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCena() {
		return cena;
	}

	public void setCena(String cena) {
		this.cena = cena;
	}

	public JogadorDTO getJogador() {
		return jogador;
	}

	public void setJogador(JogadorDTO jogador) {
		this.jogador = jogador;
	}

	public List<InimigoDTO> getInimigos() {
		return inimigos;
	}

	public void setInimigos(List<InimigoDTO> inimigos) {
		this.inimigos = inimigos;
	}

	public List<ObjetoDTO> getObjetos() {
		return objetos;
	}

	public void setObjetos(List<ObjetoDTO> objetos) {
		this.objetos = objetos;
	}

	public List<ReciclavelDTO> getReciclaveis() {
		return reciclaveis;
	}

	public void setReciclaveis(List<ReciclavelDTO> reciclaveis) {
		this.reciclaveis = reciclaveis;
	}

	public List<LixeiraDTO> getLixeiras() {
		return lixeiras;
	}

	public void setLixeiras(List<LixeiraDTO> lixeiras) {
		this.lixeiras = lixeiras;
	}
	
}
