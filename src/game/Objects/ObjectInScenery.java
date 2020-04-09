package game.Objects;

import jplay.Sprite;

public class ObjectInScenery extends Sprite {

	public ObjectInScenery(String fileName, int x, int y) {
		super(fileName, 1);
		this.x = x;
		this.y = y;
	}
}
