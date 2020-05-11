package game.telas;

import java.awt.event.KeyEvent;

import game.controles.ControleAudio;
import game.controles.ControleCenario;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Sound;
import jplay.Window;

public class TelaInicial {

	private Window janela;
	private GameImage plano = new GameImage("src/resouces/sprites/tela_inicial.png");
	private Keyboard teclado;

	public TelaInicial(Window window) {
		janela = window;
		teclado = janela.getKeyboard();
		ControleAudio.play("src/resouces/audios/vitoria.wav");
		teclado.addKey(KeyEvent.VK_E, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		teclado.addKey(KeyEvent.VK_Q, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		teclado.addKey(KeyEvent.VK_T, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		run();
	}

	private void run() {
		while (true) {
			plano.draw();
			janela.update();
			if (teclado.keyDown(KeyEvent.VK_E)) {
				ControleAudio.stop();
				new Sound("src/resouces/audios/coleta.wav").play();
				janela.delay(1000);
				ControleCenario.novoCenario(janela, 0);
			} else if (teclado.keyDown(KeyEvent.VK_Q)) {
				new Sound("src/resouces/audios/coleta.wav").play();
				janela.delay(1000);
				System.exit(0);
			} else if (teclado.keyDown(KeyEvent.VK_T)) {
				new Sound("src/resouces/audios/coleta.wav").play();
				janela.delay(1000);
				new TelaControle(janela);
			}
		}
	}
	

}
