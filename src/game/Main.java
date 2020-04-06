package game;

import game.scenarios.Scenery1;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class Main {
	
	public static void main(String[] args) {
		
		Window janela = new Window(800, 600);
		GameImage plano = new GameImage("src/resouces/sprites/telaInicial.jpg");
		Keyboard teclado = janela.getKeyboard();
		
		while(true) {
			plano.draw();
			janela.update();
			
			if(teclado.keyDown(Keyboard.ENTER_KEY)) {
				new Scenery1(janela);
			}
		}
	}
}
