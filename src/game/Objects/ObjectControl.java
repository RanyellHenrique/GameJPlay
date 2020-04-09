package game.Objects;

import java.util.List;

import game.actors.Player;
import game.actors.Zumbi;
import jplay.Scene;

public class ObjectControl {
	
	public static void renderizacaoDeObjetos(List<ObjectInScenery> objs, Player jogador, Zumbi zumbi, Scene cena) {
		for(int i=0; i<objs.size(); i++) {
			if(jogador.y - 35 > objs.get(i).y) {
				objs.get(i).x += cena.getXOffset();
				objs.get(i).y += cena.getYOffset();
				objs.get(i).draw();
			}
		}
				
		jogador.draw();
		zumbi.draw();
		
		for(int i=0; i<objs.size(); i++) {
			if(jogador.y - 35 <= objs.get(i).y) {
				objs.get(i).x += cena.getXOffset();
				objs.get(i).y += cena.getYOffset();
				objs.get(i).draw();
			}
		}
	}

}
