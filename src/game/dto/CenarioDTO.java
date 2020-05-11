package game.dto;

public class CenarioDTO {
	
	private Integer id;
	private String cena;
	
	public CenarioDTO(Integer id, String cena) {
		super();
		this.id = id;
		this.cena = cena;
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
	
	
}
