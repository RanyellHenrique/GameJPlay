package game.dto;

public class LixeiraDTO {
	
	private int x;
	private int y;
	private String url;
	private String tipo;
	private int idCenario;
	
	public LixeiraDTO(int x, int y, String url, String tipo, int idCenario) {
		this.x = x;
		this.y = y;
		this.url = url;
		this.idCenario = idCenario;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdCenario() {
		return idCenario;
	}

	public void setIdCenario(int idCenario) {
		this.idCenario = idCenario;
	}

}
