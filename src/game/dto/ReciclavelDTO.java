package game.dto;

public class ReciclavelDTO {
	
	private int x;
	private int y;
	private String url;
	private String tipo;
	
	public ReciclavelDTO(int x, int y, String url, String tipo) {
		super();
		this.x = x;
		this.y = y;
		this.url = url;
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

}
