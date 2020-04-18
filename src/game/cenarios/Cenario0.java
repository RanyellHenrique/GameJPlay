package game.cenarios;

import java.awt.Point;
import java.util.Vector;

import game.Objetos.Objeto;
import game.atores.Jogador;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Sound;
import jplay.TileInfo;
import jplay.Window;

public class Cenario0 {
	
	
	private Window janela;
	private Scene cena;
	private Jogador jogador;
	private Keyboard teclado;
	

	public Cenario0(Window window) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile("src/resouces/snc/scenery0.scn");
		jogador = new Jogador(650, 300);
		teclado = janela.getKeyboard();
		run();
	}
	
	private void run() {
		while(true) {
			jogador.mover(janela, teclado);
			jogador.caminho(cena);
			cena.moveScene(jogador);

			jogador.draw();
			
			jogador.x += cena.getXOffset();
			jogador.y += cena.getYOffset();
	
			jogador.mostrarEnergia(janela);
			new Objeto("src/resouces/sprites/dica.png", 550, 0).draw();
			
			novaFase();
			gameOver();
			
			janela.update();	
		}
	}

	public void gameOver() {
		if(jogador.energia <= 0) {
			new GameOver(janela);
		}
	}
	
	public void novaFase() {
		Point min = new Point((int)jogador.x , (int)jogador.y);
		Point max = new Point((int)jogador.x + jogador.width , (int)jogador.y + jogador.height);
		
		Vector<?> tiles = cena.getTilesFromPosition(min, max);
		
		for(int i=0; i<tiles.size(); i++) {
			TileInfo tile = (TileInfo) tiles.elementAt(i);
			if(jogador.collided(tile) && tile.id == 17) {
				new Sound("src/audios/porta.wav").play();
				janela.delay(3000);
				new Cenario1(janela);
			}
		}
	}
}
