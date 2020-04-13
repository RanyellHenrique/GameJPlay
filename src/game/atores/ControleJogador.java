package game.atores;

import game.Objects.Objeto;
import jplay.GameObject;
import jplay.TileInfo;

public class ControleJogador {
	
	public boolean colisao(GameObject obj, TileInfo tile) {
		if((tile.id >= 20) && obj.collided(tile)) {
			return true;
		}
		return false;
	}
	
	public boolean colisaoObjeto(GameObject obj, GameObject obj2) {
		if(obj.collided(obj2) && (obj2 instanceof Objeto || obj instanceof Objeto)) {
			return true;
		}
		return false;
	}
	
}
