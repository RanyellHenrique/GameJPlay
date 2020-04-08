package game.scenarios;

import game.Objects.ObjectInSnenary;
import game.actors.Player;
import game.actors.Zumbi;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Window;

public class Scenery1 {
	
	private Window janela;
	private Scene cena;
	private Player jogador;
	private Keyboard teclado;
	private Zumbi zumbi;
	private ObjectInSnenary arvore;
	private ObjectInSnenary arvore2;
	
	public Scenery1(Window window) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile("src/resouces/snc/scenery1.scn");
		jogador = new Player(650, 300);
		zumbi = new Zumbi(320, 450);
		arvore = new ObjectInSnenary("src/resouces/sprites/arvore.png", 60, 400); 
		arvore2 = new ObjectInSnenary("src/resouces/sprites/arvore.png", 450, 450); 
		teclado = janela.getKeyboard();
		run();
	}
	
	private void run() {
		while(true) {
			//cena.draw();
			jogador.mover(janela, teclado);
			jogador.caminho(cena);
			zumbi.perseguir(jogador.x, jogador.y);
			zumbi.caminho(cena);
			
			cena.moveScene(jogador);
			
			jogador.x += cena.getXOffset();
			jogador.y += cena.getYOffset();
			
			zumbi.x += cena.getXOffset();
			zumbi.y += cena.getYOffset();
			
			arvore.x += cena.getXOffset();
			arvore.y += cena.getYOffset();
			
			arvore2.x += cena.getXOffset();
			arvore2.y += cena.getYOffset();
			
			
			jogador.draw();
			zumbi.draw();
			arvore.draw();
			arvore2.draw();
			
			janela.update();
		}
	}

}
