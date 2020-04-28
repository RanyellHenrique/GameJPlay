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
import game.acoes.ControleTiro;
import game.dto.JogadorDTO;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Sound;
import jplay.Window;

public class Jogador extends Ator{
	
	public ControleTiro tiros = new ControleTiro();
	private List<Reciclavel> mochila = new ArrayList<>();
	private Objeto lixeira = new Objeto("src/resouces/sprites/mochila.png", 220, 0);
	
	Font f = new Font("arial", Font.BOLD, 30);
	Font f2 = new Font("arial", Font.BOLD, 10);
	
	public Jogador(int x, int y) {
		super("src/resouces/sprites/jogador.png", 20);
		this.x = x;
		this.y = y;
	}
	
	public Jogador(JogadorDTO obj) {
		super("src/resouces/sprites/jogador.png", 20);
		this.x = obj.getX();
		this.y = obj.getY();
	}

	public List<Reciclavel> getReciclaveis() {
		return mochila;
	}

	public void setReciclaveis(List<Reciclavel> reciclaveis) {
		this.mochila = reciclaveis;
	}

	public void mover(Window window, Keyboard teclado) {

		if(teclado.keyDown(Keyboard.LEFT_KEY)) {
			this.setTotalDuration(2000);
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
		if(this.collided(reciclavel) && teclado.keyDown(Keyboard.SPACE_KEY)) {
			this.mochila.add(reciclavel);
			somColeta();
			reciclavel.x = 100_000_000;
		}
	}
	
	private void somColeta() {
		new Sound("src/audios/coleta.wav").play();
	}
	
	public void depositarReciclavel(Lixeira lixeira, Keyboard teclado) {
		if(this.collided(lixeira)) {
			for (int i = 0; i < mochila.size(); i++) {
				if(lixeira.tipoReciclavel(mochila.get(i)) && teclado.keyDown(Keyboard.SPACE_KEY)) {
					lixeira.addReciclavel(mochila.get(i));
					mochila.remove(i);
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
		janela.drawText("X" + Reciclavel.quantidadeTipoReciclavel(mochila, TipoReciclavel.VIDRO),
				220, 40, Color.BLACK, f2);
		janela.drawText("X" + Reciclavel.quantidadeTipoReciclavel(mochila, TipoReciclavel.PAPEL),
				255, 40, Color.BLACK, f2);
		janela.drawText("X" + Reciclavel.quantidadeTipoReciclavel(mochila, TipoReciclavel.ORGÂNICO),
				285, 40, Color.BLACK, f2);
		janela.drawText("X" + Reciclavel.quantidadeTipoReciclavel(mochila, TipoReciclavel.PLÁSTICO),
				320, 40, Color.BLACK, f2);
		janela.drawText("X" + Reciclavel.quantidadeTipoReciclavel(mochila, TipoReciclavel.METAL),
				350, 40, Color.BLACK, f2);
	}
	
}
