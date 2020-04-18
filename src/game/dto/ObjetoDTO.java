package game.dto;

public class ObjetoDTO {
	
	private int x;
	private int y;
	private String url;
	
	public ObjetoDTO(int x, int y, String url) {
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
	
}
