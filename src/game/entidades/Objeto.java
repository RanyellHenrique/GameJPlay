package game.entidades;

import game.dto.ObjetoDTO;
import jplay.Scene;
import jplay.Sprite;

public class Objeto extends Sprite {
	
	private boolean caminho;

	public Objeto(String fileName, int x, int y) {
		super(fileName, 1);
		this.x = x;
		this.y = y;
	}
	
	public Objeto(ObjetoDTO obj) {
		super(obj.getUrl(), 1);
		this.x = obj.getX();
		this.y = obj.getY();
		this.caminho = obj.getCaminho();
	}
	
	public void showObject(Scene cena){
		this.x += cena.getXOffset();
		this.y += cena.getYOffset();
		this.draw();
	}

	public boolean isCaminho() {
		return caminho;
	}

	public void setCaminho(boolean caminho) {
		this.caminho = caminho;
	}
}
