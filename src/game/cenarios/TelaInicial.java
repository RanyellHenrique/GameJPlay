package game.cenarios;

import java.awt.event.KeyEvent;

import game.audios.Audio;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Sound;
import jplay.Window;

public class TelaInicial {

	private Window janela;
	private GameImage plano = new GameImage("src/resouces/sprites/telaInicial.png");
	private Keyboard teclado;

	public TelaInicial(Window window) {
		janela = window;
		teclado = janela.getKeyboard();
		Audio.play("src/audios/vitoria.wav");
		teclado.addKey(KeyEvent.VK_E, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		teclado.addKey(KeyEvent.VK_Q, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		run();
	}

	private void run() {
		while (true) {
			plano.draw();
			janela.update();
			if (teclado.keyDown(KeyEvent.VK_E)) {
				Audio.stop();
				new Sound("src/audios/coleta.wav").play();
				janela.delay(1000);
				ControleCenario.novoCenario(janela, 0);
			} else if (teclado.keyDown(KeyEvent.VK_Q)) {
				new Sound("src/audios/coleta.wav").play();
				janela.delay(1000);
				System.exit(0);
			}
		}
	}
	

}
