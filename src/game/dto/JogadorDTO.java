package game.dto;

public class JogadorDTO {
	
	private int x;
	private int y;
	private int idCenario;
	
	public JogadorDTO(int x, int y, int idCenario) {
		super();
		this.x = x;
		this.y = y;
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

	public int getIdCenario() {
		return idCenario;
	}

	public void setIdCenario(int idCenario) {
		this.idCenario = idCenario;
	}

}
