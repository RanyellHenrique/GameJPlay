package game.atores;

import jplay.GameObject;
import jplay.TileInfo;

public class ControleJogador {
	
	public boolean colisao(GameObject obj, TileInfo tile) {
		if((tile.id > 20) && obj.collided(tile)) {
			return true;
		}
		return false;
	}
}
