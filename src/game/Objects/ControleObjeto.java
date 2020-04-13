package game.Objects;

import java.util.ArrayList;
import java.util.List;

import game.atores.Jogador;
import game.atores.Zumbi;
import jplay.Scene;

public class ControleObjeto {
	
	public static List<Objeto> objectInScenery(){
		List<Objeto> objects = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			if(i%2 == 0)
				objects.add(new Objeto("src/resouces/sprites/arvore.png", 150 * (1 * i), 400 + 20 * i));
			else
				objects.add(new Objeto("src/resouces/sprites/arvore.png", 200 * (1 * i), 350 + 10 * i));
		}
		return objects;
	}
	
	public static void renderizacaoDeObjetos(List<Objeto> objs, Jogador jogador, List<Zumbi> zumbis, Scene cena) {
		for(int i=0; i<objs.size(); i++) {
			if(jogador.y - 35 > objs.get(i).y) {
				objs.get(i).showObject(cena);
			}
		}
				
		jogador.draw();
		for (int i = 0; i < zumbis.size(); i++) {
			zumbis.get(i).draw();
		}
		
		for(int i=0; i<objs.size(); i++) {
			if(jogador.y - 35 <= objs.get(i).y) {
				objs.get(i).showObject(cena);
			}
		}
	}
}
