package game.Objetos;

import game.dto.ObjetoDTO;
import jplay.Scene;
import jplay.Sprite;

public class Objeto extends Sprite {

	public Objeto(String fileName, int x, int y) {
		super(fileName, 1);
		this.x = x;
		this.y = y;
	}
	
	public Objeto(ObjetoDTO obj) {
		super(obj.getUrl(), 1);
		this.x = obj.getX();
		this.y = obj.getY();
	}
	
	public void showObject(Scene cena){
		this.x += cena.getXOffset();
		this.y += cena.getYOffset();
		this.draw();
	}
}
