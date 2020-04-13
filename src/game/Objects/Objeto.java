package game.Objects;

import jplay.Scene;
import jplay.Sprite;

public class Objeto extends Sprite {

	public Objeto(String fileName, int x, int y) {
		super(fileName, 1);
		this.x = x;
		this.y = y;
	}
	
	public void showObject(Scene cena){
		this.x += cena.getXOffset();
		this.y += cena.getYOffset();
		this.draw();
	}
}
