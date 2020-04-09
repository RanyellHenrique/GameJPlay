package game.Objects;

import java.util.ArrayList;
import java.util.List;

import game.actors.Player;
import game.actors.Zumbi;
import jplay.Scene;

public class ObjectControl {
	
	public static List<ObjectInScenery> objectInScenery(){
		List<ObjectInScenery> objects = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			if(i%2 == 0)
				objects.add(new ObjectInScenery("src/resouces/sprites/arvore.png", 150 * (1 * i), 400 + 20 * i));
			else
				objects.add(new ObjectInScenery("src/resouces/sprites/arvore.png", 200 * (1 * i), 350 + 10 * i));
		}
		return objects;
	}
	
	public static void renderizacaoDeObjetos(List<ObjectInScenery> objs, Player jogador, List<Zumbi> zumbis, Scene cena) {
		for(int i=0; i<objs.size(); i++) {
			if(jogador.y - 35 > objs.get(i).y) {
				objs.get(i).x += cena.getXOffset();
				objs.get(i).y += cena.getYOffset();
				objs.get(i).draw();
			}
		}
				
		jogador.draw();
		for (int i = 0; i < zumbis.size(); i++) {
			zumbis.get(i).draw();
		}
		
		for(int i=0; i<objs.size(); i++) {
			if(jogador.y - 35 <= objs.get(i).y) {
				objs.get(i).x += cena.getXOffset();
				objs.get(i).y += cena.getYOffset();
				objs.get(i).draw();
			}
		}
	}
}
