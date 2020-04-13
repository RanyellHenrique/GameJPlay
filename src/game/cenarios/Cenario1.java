package game.cenarios;

import java.util.List;

import game.Objects.ControleObjeto;
import game.Objects.Objeto;
import game.atores.Jogador;
import game.atores.Zumbi;
import game.atores.ControleZumbi;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Window;

public class Cenario1 {
	
	private Window janela;
	private Scene cena;
	private Jogador jogador;
	private Keyboard teclado;
	private List<Objeto> arvores;
	private List<Zumbi> zumbis;
	
	public Cenario1(Window window) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile("src/resouces/snc/scenery1.scn");
		jogador = new Jogador(650, 300);
		//Audio.play("src/audios/musica.wav");
		arvores = ControleObjeto.objectInScenery();
		zumbis = ControleZumbi.zumbis();
		teclado = janela.getKeyboard();
		
		run();
	}
	
	private void run() {
		while(true) {
			//cena.draw();
			jogador.mover(janela, teclado);
			jogador.caminho(cena);
			cena.moveScene(jogador);
			
			ControleObjeto.renderizacaoDeObjetos(arvores, jogador, zumbis, cena);
			ControleZumbi.renderizacaoDeZumbis(zumbis, jogador, cena, arvores, teclado, janela);
			
			jogador.x += cena.getXOffset();
			jogador.y += cena.getYOffset();
			jogador.mostrarEnergia(janela);
			
			janela.update();
		}
	}

}
