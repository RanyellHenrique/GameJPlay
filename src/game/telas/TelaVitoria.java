package game.telas;

import java.awt.event.KeyEvent;

import game.controles.ControleAudio;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Sound;
import jplay.Window;

public class TelaVitoria {
	
	private Window janela;
	GameImage plano = new GameImage("src/resouces/sprites/vitoria.png");
	private Keyboard teclado;
	
	public TelaVitoria(Window window) {
		janela = window;
		teclado = janela.getKeyboard();
		ControleAudio.play("src/resouces/audios/vitoria.wav");
		teclado.addKey(KeyEvent.VK_T, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		
		run();
	}
	
	private void run() {
		while(true) {
			plano.draw();
			janela.update();
			janela.delay(1000);
			if(teclado.keyDown(KeyEvent.VK_T)) {
				new Sound("src/resouces/audios/coleta.wav").play();
				janela.delay(1000);
				ControleAudio.stop();
				new TelaInicial(janela);
			}	
		}
	}

}
