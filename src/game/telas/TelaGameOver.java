package game.telas;

import java.awt.event.KeyEvent;

import game.controles.ControleAudio;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Sound;
import jplay.Window;

public class TelaGameOver {
	
	private Window janela;
	GameImage plano = new GameImage("src/resouces/sprites/gameOver.png");
	private Keyboard teclado;

	
	public TelaGameOver(Window window) {
		janela = window;
		teclado = janela.getKeyboard();
		ControleAudio.play("src/resouces/audios/gameOver.wav");
		teclado.addKey(KeyEvent.VK_T, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		
		run();
	}
	
	private void run() {
		while(true) {
			plano.draw();
			janela.update();
		
			if(teclado.keyDown(KeyEvent.VK_T)) {
				ControleAudio.stop();
				new Sound("src/resouces/audios/coleta.wav").play();
				janela.delay(1000);
				new TelaInicial(janela);
			}	
		}
	}
	
}
