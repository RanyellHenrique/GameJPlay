package game.scenarios;

import game.players.Player;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Window;

public class Scenery1 {
	
	private Window janela;
	private Scene cena;
	private Player jogador;
	private Keyboard teclado;
	
	public Scenery1(Window window) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile("src/resouces/snc/scenery1.scn");
		jogador = new Player(800, 600);
		teclado = janela.getKeyboard();
		run();
	}
	
	private void run() {
		while(true) {
			//cena.draw();
			jogador.mover(janela, teclado);
			jogador.caminho(cena);
			
			cena.moveScene(jogador);
			
			jogador.x += cena.getXOffset();
			jogador.y += cena.getYOffset();
			
			jogador.draw();
			janela.update();
		}
	}

}
