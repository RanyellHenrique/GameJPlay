package game.actors;

import java.awt.event.KeyEvent;

import game.actions.TiroControl;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Window;

public class Player extends Actor{
	
	TiroControl tiros = new TiroControl();
	

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
	
	public void atirar(Window janela, Scene cena, Keyboard teclado, Actor inimigo) {
		if(teclado.keyDown(KeyEvent.VK_A)) {
			tiros.adiciononaTiro(x, y + 11, direcao, cena);
		}
		tiros.run(inimigo);
	}
}
