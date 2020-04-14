package game.cenarios;

import game.audios.Audio;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class GameOver {
	
	private Window janela;
	GameImage plano = new GameImage("src/resouces/sprites/gameOver.png");
	private Keyboard teclado;

	
	public GameOver(Window window) {
		janela = window;
		teclado = janela.getKeyboard();
		Audio.play("src/audios/musica.wav");
		
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
