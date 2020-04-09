package game.scenarios;

import java.util.List;

import game.Objects.ObjectControl;
import game.Objects.ObjectInScenery;
import game.actors.Player;
import game.actors.Zumbi;
import game.actors.ZumbiControl;
import game.audios.Audio;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Window;

public class Scenery1 {
	
	private Window janela;
	private Scene cena;
	private Player jogador;
	private Keyboard teclado;
	private List<ObjectInScenery> arvores;
	private List<Zumbi> zumbis;
	
	public Scenery1(Window window) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile("src/resouces/snc/scenery1.scn");
		jogador = new Player(650, 300);
		Audio.play("src/audios/musica.wav");
		arvores = ObjectControl.objectInScenery();
		zumbis = ZumbiControl.zumbis();
		teclado = janela.getKeyboard();
		
		run();
	}
	
	private void run() {
		while(true) {
			//cena.draw();
			jogador.mover(janela, teclado);
			jogador.caminho(cena);
			cena.moveScene(jogador);
			
			ObjectControl.renderizacaoDeObjetos(arvores, jogador, zumbis, cena);
			ZumbiControl.renderizacaoDeZumbis(zumbis, jogador, cena, arvores, teclado, janela);
			
			jogador.x += cena.getXOffset();
			jogador.y += cena.getYOffset();
			jogador.mostrarEnergia(janela);
			
			janela.update();
		}
	}

}
