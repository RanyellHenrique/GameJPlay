package game.actors;

import game.Objects.ObjectInScenery;
import jplay.GameObject;
import jplay.TileInfo;

public class ActorControl {
	
	public boolean colisao(GameObject obj, TileInfo tile) {
		if((tile.id >= 20) && obj.collided(tile)) {
			return true;
		}
		return false;
	}
	
	public boolean colisaoObjeto(GameObject obj, GameObject obj2) {
		if(obj.collided(obj2) && (obj2 instanceof ObjectInScenery || obj instanceof ObjectInScenery)) {
			return true;
		}
		return false;
	}
	
}
