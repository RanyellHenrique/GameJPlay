package game.atores;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import game.Objetos.Lixeira;
import game.Objetos.Objeto;
import game.Objetos.Reciclavel;
import game.Objetos.TipoReciclavel;
import game.actions.ControleTiro;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Sound;
import jplay.Window;

public class Jogador extends Ator{
	
	ControleTiro tiros = new ControleTiro();
	Font f = new Font("arial", Font.BOLD, 30);
	Font f2 = new Font("arial", Font.BOLD, 10);
	private List<Reciclavel> reciclaveis = new ArrayList<>();
	private Objeto lixeira = new Objeto("src/resouces/sprites/mochila.png", 220, 0);

	public Jogador(int x, int y) {
		super("src/resouces/sprites/jogador.png", 20);
		this.x = x;
		this.y = y;
	}

	public List<Reciclavel> getReciclaveis() {
		return reciclaveis;
	}

	public void setReciclaveis(List<Reciclavel> reciclaveis) {
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
	
	public void coletarReciclavel(Reciclavel reciclavel, Keyboard teclado) {
		if(this.collided(reciclavel) && teclado.keyDown(KeyEvent.VK_SPACE)) {
			this.reciclaveis.add(reciclavel);
			somColeta();
			reciclavel.x = 100_000_000;
		}
	}
	
	private void somColeta() {
		new Sound("src/audios/coleta.wav").play();
	}
	
	public void depositarReciclavel(Lixeira lixeira, Keyboard teclado) {
		if(this.collided(lixeira) && teclado.keyDown(KeyEvent.VK_SPACE)) {
			for (int i = 0; i < reciclaveis.size(); i++) {
				if(lixeira.addReciclavel(reciclaveis.get(i))) {
					reciclaveis.remove(i);
					somDeposito();
				}
			}
		}
	}
	
	private void somDeposito() {
		new Sound("src/audios/deposito.wav").play();
	}
	
	public void mostrarEnergia(Window janela) {
		janela.drawText("HP: " + energia , 30, 30, Color.BLACK, f);
	}
	
	public void mostrarMochila(Window janela) {
		lixeira.draw();
		janela.drawText("X" + Reciclavel.quantidadeTipoReciclavel(reciclaveis, TipoReciclavel.VIDRO),
				220, 40, Color.BLACK, f2);
		janela.drawText("X" + Reciclavel.quantidadeTipoReciclavel(reciclaveis, TipoReciclavel.PAPEL),
				255, 40, Color.BLACK, f2);
		janela.drawText("X" + Reciclavel.quantidadeTipoReciclavel(reciclaveis, TipoReciclavel.ORGÂNICO),
				285, 40, Color.BLACK, f2);
		janela.drawText("X" + Reciclavel.quantidadeTipoReciclavel(reciclaveis, TipoReciclavel.PLÁSTICO),
				320, 40, Color.BLACK, f2);
		janela.drawText("X" + Reciclavel.quantidadeTipoReciclavel(reciclaveis, TipoReciclavel.METAL),
				350, 40, Color.BLACK, f2);
	}
	
}