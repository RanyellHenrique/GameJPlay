package game.atores;

import java.util.List;

import game.Objetos.Reciclavel;
import game.Objetos.TipoReciclavel;
import jplay.Scene;
import jplay.Sound;

public class Inimigo  extends Ator{
	
	private double ataque = 1;
	private boolean morrer = false;

	public Inimigo(int x, int y) {
		super("src/resouces/sprites/zumbi.png", 16);
		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
		this.velocidade = 0.3;
	}
	
	public double getAtaque() {
		return ataque;
	}

	public void setAtaque(double ataque) {
		this.ataque = ataque;
	}

	public boolean getMorrer() {
		return morrer;
	}

	public void setMorrer(boolean morrer) {
		this.morrer = morrer;
	}

	public void perseguir(double x, double y) {
		if(this.x > x && this.y <= y + 50 && this.y >= y - 50) {
			moveTo(x, y, velocidade);
			if(direcao != 1) {
				setSequence(5, 8);
				direcao = 1;
			} movendo = true;
		}
		else if(this.x < x && this.y <= y + 50 && this.y >= -50) {
			moveTo(x, y, velocidade);
			if(direcao != 2) {
				setSequence(9, 12);
				direcao = 2;
			}movendo = true;
		}
		else if(this.y > y) {
			moveTo(x, y, velocidade);
			if(direcao != 4) {
				setSequence(13, 16);
				direcao = 4;
			}movendo = true;
		}
		else if(this.y < y) {
			moveTo(x, y, velocidade);
			if(direcao != 5) {
				setSequence(1, 4);
				direcao = 5;
			}movendo = true;
		}
		if(movendo) {
			update();
			movendo = false;
		}
	}

	public void morrer(Scene cena, List<Reciclavel> objetosReciclaveis) {
		if(this.energia <= 0) {
			this.velocidade = 0;
			this.ataque = 0;
			this.direcao = 0;
			this.movendo = false;
			lixoDropado(cena, objetosReciclaveis);
			morrer = true;
			this.x = 100_000_000;
		}
	}
	
	
	public void atacar(Jogador jogador) {
		if(this.collided(jogador)) {
			jogador.energia -= this.ataque ;
		}
		if(jogador.energia <= 0) {
			System.exit(0);
		}
	}
	
	public void lixoDropado(Scene cena, List<Reciclavel> objetosReciclaveis) {
		if(!morrer) {
			objetosReciclaveis.add(new Reciclavel("", (int)this.x, (int)this.y, TipoReciclavel.random()));
			somLixoDropado();
		}
	}
	
	private void somLixoDropado() {
		new Sound("src/audios/poof.wav").play();
	}
	
	
}