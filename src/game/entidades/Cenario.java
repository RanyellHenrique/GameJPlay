package game.entidades;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import game.servicos.CenarioServicos;
import game.telas.TelaGameOver;
import game.telas.TelaVitoria;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Sound;
import jplay.TileInfo;
import jplay.Window; 

public class Cenario {
	
	public Integer id;
	public Window janela;
	public Scene cena;
	public Keyboard teclado;
	public Jogador jogador;
	public List<Inimigo> inimigos = new ArrayList<>();
	public List<Objeto> objetos = new ArrayList<>();
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
			cena.moveScene(jogador);
			showJogador();
			showLixeiras();
			showReciclaveis();
			showObjetos();
			showinimigos();
			novaFase();
			gameOver();
			janela.update();
		}
	}
	
	public void showJogador() {
		jogador.mover(janela, teclado);
		jogador.caminhoObjeto(objetos);
		jogador.x += cena.getXOffset();
		jogador.y += cena.getYOffset();
		jogador.caminho(cena);
		jogador.painelDeInformacao(janela);
	}
	
	public void showObjetos() {
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
		if(reciclaveis >= inimigos.size()) {
			Point min = new Point((int)jogador.x , (int)jogador.y);
			Point max = new Point((int)jogador.x + jogador.width , (int)jogador.y + jogador.height);
			Vector<?> tiles = cena.getTilesFromPosition(min, max);
			
			new Objeto("src/resouces/sprites/fase_concluida.png", 550, 0).draw();
			
			for(int i=0; i<tiles.size(); i++) {
				TileInfo tile = (TileInfo) tiles.elementAt(i);
				if(jogador.collided(tile) && (tile.id == 17 || tile.id == 19)) {
					new Sound("src/resouces/audios/porta.wav").play();
					janela.delay(2000);
					if(this.id >= 2)
						new TelaVitoria(janela);
					CenarioServicos ce = new CenarioServicos();
					ce.buscarPorId(this.id + 1, janela);
				}
			}
		}
	}
	
	public void gameOver() {
		if(jogador.energia <= 0) {
			new TelaGameOver(janela);
		}
	}
}
