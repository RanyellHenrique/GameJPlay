package game.controles;

import game.entidades.Objeto;
import jplay.GameObject;
import jplay.TileInfo;

public class ControleJogador {
	
	public boolean colisao(GameObject obj, TileInfo tile) {
		if((tile.id > 20) && obj.collided(tile))
			return true;
		return false;
	}
	
	public boolean colisaoObjeto(GameObject obj, Objeto obj2) {
		if(obj.collided(obj2) && obj2.isCaminho())
			return true;
		return false;
	}
}
