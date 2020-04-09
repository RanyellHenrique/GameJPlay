package game.actions;

import java.util.LinkedList;

import game.actors.Actor;
import jplay.Scene;
import jplay.Sound;

public class TiroControl {
	
	LinkedList<Tiro> tiros = new LinkedList<>();
	
	public void adiciononaTiro(double x, double y, int caminho, Scene cena) {
		Tiro tiro = new Tiro(x, y, caminho);
		tiros.addFirst(tiro);
		cena.addOverlay(tiro);
		somDisparo();
	}
	
	public void run(Actor inimigo) {
		for (int i = 0; i < tiros.size(); i++) {
			Tiro tiro = tiros.removeFirst();
			tiro.mover();
			tiros.addLast(tiro);
			
			if(tiro.collided(inimigo)) {
				tiro.x = 10_000_000;
				inimigo.energia -= 250;
			}
		}
	}

	private void somDisparo() {
		new Sound("src/audios/flecha.wav").play();
	}

}
