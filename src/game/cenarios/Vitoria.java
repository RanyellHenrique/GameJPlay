package game.cenarios;

import game.audios.Audio;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class Vitoria {
	
	private Window janela;
	GameImage plano = new GameImage("src/resouces/sprites/vitoria.png");
	private Keyboard teclado;

	
	public Vitoria(Window window) {
		janela = window;
		teclado = janela.getKeyboard();
		Audio.play("src/audios/vitoria.wav");
		
		run();
	}
	
	private void run() {
		while(true) {
			plano.draw();
			janela.update();
		
			if(teclado.keyDown(Keyboard.ENTER_KEY)) {
				Audio.stop();
				new Cenario1(janela);
			}	
		}
	}

}
