package game.actions;

import java.util.LinkedList;

import game.atores.Ator;
import jplay.Scene;
import jplay.Sound;

public class ControleTiro {
	
	LinkedList<Tiro> tiros = new LinkedList<>();
	
	public void adiciononaTiro(double x, double y, int caminho, Scene cena) {
		Tiro tiro = new Tiro(x, y, caminho);
		tiros.addFirst(tiro);
		cena.addOverlay(tiro);
		somDisparo();
	}
	
	public void run(Ator inimigo) {
		for (int i = 0; i < tiros.size(); i++) {
			Tiro tiro = tiros.removeFirst();
			tiro.mover();
			tiros.addLast(tiro);
			
			if(tiro.collided(inimigo)) {
				tiro.x = 10_000_000;
				inimigo.energia -= 250;
			}
			
			if(tiro.y > 620 || tiro.y < 0)
				tiro.x = 10_000_000;
			
			if(tiro.x > 800 || tiro.x < 0)
				tiro.x = 10_000_000;
		}
	}

	private void somDisparo() {
		new Sound("src/audios/flecha.wav").play();
	}

}
