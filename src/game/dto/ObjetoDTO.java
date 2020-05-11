package game.dto;

public class ObjetoDTO {
	
	private int x;
	private int y;
	private String url;
	private boolean caminho;
	private int idCenario;
	
	public ObjetoDTO(int x, int y, String url, boolean caminho, int idCenario) {
		this.x = x;
		this.y = y;
		this.url = url;
		this.setCaminho(caminho);
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

	public boolean getCaminho() {
		return caminho;
	}

	public void setCaminho(boolean caminho) {
		this.caminho = caminho;
	}

	public int getIdCenario() {
		return idCenario;
	}

	public void setIdCenario(int idCenario) {
		this.idCenario = idCenario;
	}
	
}
