package game.atores;

import java.awt.Point;
import java.util.List;
import java.util.Vector;

import game.Objetos.Objeto;
import jplay.GameObject;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;

public class Ator extends Sprite {
	
	protected double velocidade = 1;
	protected int direcao = 3;
	protected boolean movendo = false;
	protected ControleJogador controle = new ControleJogador();
	public double energia = 1000;
	
	public Ator(String fileName, int numFrames) {
		super(fileName, numFrames);
	}
	
	
	public void caminho(Scene cena) {
		Point min = new Point((int)this.x , (int)this.y);
		Point max = new Point((int)this.x + this.width , (int)this.y + this.height);
		
		Vector<?> tiles = cena.getTilesFromPosition(min, max);
		
		for(int i=0; i<tiles.size(); i++) {
			TileInfo tile = (TileInfo) tiles.elementAt(i);
			if(controle.colisao(this, tile) == true) {
				if(colisaoVertical(this, tile)) {
					if(tile.y + tile.height - 2 < this.y) {
						this.y = tile.y + tile.height;
					}
					else if(tile.y > this.y + this.height - 2) {
						this.y = tile.y - this.height;
					}
				}
				if(colisaoHorizontal(this, tile)) {
					if(tile.x > this.x + this.width - 2) {
						this.x = tile.x - this.width;
					}
					else { 
						this.x = tile.x + tile.width;
					}
				}
			}
		}
	}
	
	public void caminhoObjeto(List<Objeto> objs) {
		for(int i=0; i< objs.size(); i++) {
			Objeto obj2 = objs.get(i);
			if(controle.colisaoObjeto(this, obj2)) {
				if(colisaoVertical(this, obj2)) {
					if(obj2.y + obj2.height - 2 < this.y) {
						this.y = obj2.y + obj2.height;
					}
					else if(obj2.y > this.y + this.height - 2) {
						this.y = obj2.y - this.height;
					}
				}
				if(colisaoHorizontal(this, obj2)) {
					if(obj2.x > this.x + this.width - 2) {
						this.x = obj2.x - this.width;
					}
					else { 
						this.x = obj2.x + obj2.width;
					}
				}
			}
		}
	}
	
	
	
	public boolean colisaoVertical(GameObject obj, GameObject obj2) {
		if(obj2.x + obj2.width <= obj.x)
			return false;
		if(obj.x + obj.width <= obj2.x)
			return false;
		return true;
	}
	
	public boolean colisaoHorizontal(GameObject obj, GameObject obj2) {
		if(obj2.y + obj2.height <= obj.y) 
			return false;
		if(obj.y + obj.height <= obj2.y) 
			return false;
		return true;
	}

}
