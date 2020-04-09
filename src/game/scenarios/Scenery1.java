package game.scenarios;

import java.util.ArrayList;
import java.util.List;

import game.Objects.ObjectInScenery;
import game.Objects.ObjectControl;
import game.actors.Player;
import game.actors.Zumbi;
import game.audios.Audio;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Window;

public class Scenery1 {
	
	private Window janela;
	private Scene cena;
	private Player jogador;
	private Keyboard teclado;
	private Zumbi zumbi;
	private List<ObjectInScenery> arvores = new ArrayList<>();
	
	public Scenery1(Window window) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile("src/resouces/snc/scenery1.scn");
		jogador = new Player(650, 300);
		zumbi = new Zumbi(320, 450);
		//Audio.play("src/audios/musica.wav");
		for(int i=0; i<5; i++) {
			if(i%2 == 0)
				arvores.add(new ObjectInScenery("src/resouces/sprites/arvore.png", 150 * (1 * i), 400 + 20 * i));
			else
				arvores.add(new ObjectInScenery("src/resouces/sprites/arvore.png", 200 * (1 * i), 350 + 10 * i));
		}
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
			jogador.atirar(janela, cena, teclado, zumbi);
			zumbi.morrer();
			
			cena.moveScene(jogador);
			
			jogador.x += cena.getXOffset();
			jogador.y += cena.getYOffset();
			
			zumbi.x += cena.getXOffset();
			zumbi.y += cena.getYOffset();
			
			ObjectControl.renderizacaoDeObjetos(arvores, jogador, zumbi, cena);
			
			janela.update();
		}
	}

}
