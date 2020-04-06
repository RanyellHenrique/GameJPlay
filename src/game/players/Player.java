package game.players;

import java.awt.Point;
import java.util.Vector;

import game.controls.control;
import jplay.GameObject;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;
import jplay.Window;

public class Player extends Sprite{
	
	private double velocidade = 1;
	private int direcao = 3;
	private boolean movendo = false;
	private control controle = new control();

	public Player(int x, int y) {
		super("src/resouces/sprites/jogador.png", 20);
		this.x = x;
		this.y = y;
	}

	public void mover(Window window, Keyboard teclado) {
		
		if(teclado.keyDown(Keyboard.LEFT_KEY)) {
			if(this.x > 0) this.x -= velocidade;
			if(direcao != 1) {
				setSequence(4, 8);
				direcao = 1;
			}movendo = true;
		}
		else if(teclado.keyDown(Keyboard.RIGHT_KEY)) {
			if(this.x < window.getWidth() - 60) this.x += velocidade;
			if(direcao != 2) {
				setSequence(8, 12);
				direcao = 2;
			}movendo = true;		
		}
		else if(teclado.keyDown(Keyboard.UP_KEY)) {
			if(this.y > 0) this.y -= velocidade;
			if(direcao != 4) {
				setSequence(12, 16);
				direcao = 4;
			}movendo = true;		
		}
		else if(teclado.keyDown(Keyboard.DOWN_KEY)) {
			if(this.y < window.getHeight() - 60) this.y += velocidade;
			if(direcao != 5) {
				setSequence(0, 4);
				direcao = 5;
			}movendo = true;		
		}
		if(movendo) {
			update();
			movendo = false;
		}
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
						this.x = tile.x - tile.width;
					}
					else { 
						this.x = tile.x + tile.width;
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
