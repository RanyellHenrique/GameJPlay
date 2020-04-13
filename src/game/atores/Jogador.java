package game.atores;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import game.Objetos.ObjetoReciclavel;
import game.actions.ControleTiro;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Window;

public class Jogador extends Ator{
	
	ControleTiro tiros = new ControleTiro();
	Font f = new Font("arial", Font.BOLD, 30);
	private List<ObjetoReciclavel> reciclaveis = new ArrayList<>(); 

	public Jogador(int x, int y) {
		super("src/resouces/sprites/jogador.png", 20);
		this.x = x;
		this.y = y;
	}

	public List<ObjetoReciclavel> getReciclaveis() {
		return reciclaveis;
	}

	public void setReciclaveis(List<ObjetoReciclavel> reciclaveis) {
		this.reciclaveis = reciclaveis;
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
	
	public void atirar(Window janela, Scene cena, Keyboard teclado, Ator inimigo) {
		if(teclado.keyDown(KeyEvent.VK_A)) {
			tiros.adiciononaTiro(x, y + 11, direcao, cena);
		}
		tiros.run(inimigo);
	}
	
	public void mostrarEnergia(Window janela) {
		janela.drawText("HP: " + energia , 30, 30, Color.BLACK, f);
	}
	
	public void coletarReciclavel(ObjetoReciclavel reciclavel) {
		if(this.collided(reciclavel)) {
			this.reciclaveis.add(reciclavel);
			reciclavel.x = 100_000_000;
		}
	}
}
