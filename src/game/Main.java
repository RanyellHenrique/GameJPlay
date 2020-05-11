package game;

import game.telas.TelaInicial;
import jplay.Window;

public class Main {
	
	public static void main(String[] args) {
		
		Window janela = new Window(800, 600);
		while(true) {
				new TelaInicial(janela);
		}
	}
}
