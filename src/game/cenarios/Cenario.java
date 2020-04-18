package game.cenarios;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import game.Objetos.Lixeira;
import game.Objetos.Objeto;
import game.Objetos.Reciclavel;
import game.atores.Inimigo;
import game.atores.Jogador;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Sound;
import jplay.TileInfo;
import jplay.Window; 

public class Cenario {
	
	public Integer id;
	public Window janela;
	public Scene cena;
	public Jogador jogador;
	public Keyboard teclado;
	public List<Objeto> objetos = new ArrayList<>();
	public List<Inimigo> inimigos = new ArrayList<>();
	public List<Reciclavel> reciclaveis = new ArrayList<>();
	public List<Lixeira> lixeiras = new ArrayList<>();
	
	public Cenario() {
		
	}

	public Cenario( Integer id, Window janela, Jogador jogador, String cena,
			List<Objeto> objetos, List<Inimigo> inimigos, List<Lixeira> lixeiras) {
		this.id = id;
		this.janela = janela;
		this.cena = new Scene();
		this.cena.loadFromFile(cena);
		this.jogador = jogador;
		this.objetos = objetos;
		this.inimigos = inimigos;
		this.lixeiras = lixeiras;
		teclado = janela.getKeyboard();
		run();
	}
	
	public Cenario(String cena) {
		this.cena = new Scene();
		this.cena.loadFromFile(cena);
		teclado = janela.getKeyboard();
		run();
	}
	
	private void run() {
		while(true) {
			jogador.mover(janela, teclado);
			jogador.caminho(cena);
			jogador.caminhoObjeto(objetos);
			cena.moveScene(jogador);
			
			showLixeiras();
			showReciclaveis();
			showArvores();
			showinimigos();
			
			jogador.x += cena.getXOffset();
			jogador.y += cena.getYOffset();
	
			jogador.mostrarEnergia(janela);
			jogador.mostrarMochila(janela);
			
			novaFase();
			gameOver();
			
			janela.update();	
		}
	}
	
	public void showArvores() {
		for(int i=0; i<objetos.size(); i++) {
			if(jogador.y - 35 > objetos.get(i).y)
				objetos.get(i).showObject(cena);
		}	
		jogador.draw();
		for (int i = 0; i < inimigos.size(); i++) {
			inimigos.get(i).draw();
		}
		for(int i=0; i<objetos.size(); i++) {
			if(jogador.y - 35 <= objetos.get(i).y)
				objetos.get(i).showObject(cena);
		}
	}
	
	public  void showinimigos() {
		Inimigo inimigo;
		for(int i=0; i<inimigos.size(); i++) {
			inimigo = inimigos.get(i);
			inimigo.perseguir(jogador.x, jogador.y);
			inimigo.caminho(cena);
			inimigo.caminhoObjeto(objetos);
			jogador.atirar(janela, cena, teclado, inimigo);
			inimigo.morrer(cena, reciclaveis);
			inimigo.atacar(jogador);
			inimigo.x += cena.getXOffset();
			inimigo.y += cena.getYOffset();
		}	
	}
	
	
	public void showReciclaveis() {
		Reciclavel reciclavel;
		for (int i = 0; i < reciclaveis.size(); i++) {
			reciclavel = reciclaveis.get(i);
			reciclavel.showObject(cena);
			jogador.coletarReciclavel(reciclavel, teclado);
		}
	}
	
	public  void showLixeiras() {
		for(Lixeira lixeira : lixeiras) {
			lixeira.showObject(cena);
			jogador.depositarReciclavel(lixeira, teclado);
		}
	}
	
	
	public void novaFase() {
		Integer reciclaveis = 0;
		for(Lixeira lixeira : lixeiras) {
			reciclaveis += lixeira.getReciclaveis().size();
		}
		if(reciclaveis == 10) {
			Point min = new Point((int)jogador.x , (int)jogador.y);
			Point max = new Point((int)jogador.x + jogador.width , (int)jogador.y + jogador.height);
			
			Vector<?> tiles = cena.getTilesFromPosition(min, max);
			
			new Objeto("src/resouces/sprites/dica2.png", 550, 0).draw();
			
			for(int i=0; i<tiles.size(); i++) {
				TileInfo tile = (TileInfo) tiles.elementAt(i);
				if(jogador.collided(tile) && (tile.id == 17 || tile.id == 19)) {
					new Sound("src/audios/porta.wav").play();
					janela.delay(2000);
					ControleCenario.novoCenario(janela, this.id + 1);
				}
			}
		}
	}
	
	public void gameOver() {
		if(jogador.energia <= 0) {
			new GameOver(janela);
		}
	}
}
