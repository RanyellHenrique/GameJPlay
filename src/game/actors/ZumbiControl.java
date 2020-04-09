package game.actors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.Objects.ObjectInScenery;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Window;

public class ZumbiControl {
	
	private static Random gerador = new Random();
	
	public static List<Zumbi> zumbis(){
		List<Zumbi> zumbs = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			zumbs.add(new Zumbi(gerador.nextInt(789), 100 + gerador.nextInt(590)));
		}
		return zumbs;
	}
	
	public static void renderizacaoDeZumbis(List<Zumbi> zumbis, Player jogador,
			Scene cena, List<ObjectInScenery> arvores, Keyboard teclado, Window janela) {
		for(int i=0; i<zumbis.size(); i++) {
			zumbis.get(i).perseguir(jogador.x, jogador.y);
			zumbis.get(i).caminho(cena);
			jogador.atirar(janela, cena, teclado, zumbis.get(i));
			zumbis.get(i).morrer();
			zumbis.get(i).atacar(jogador);
			zumbis.get(i).x += cena.getXOffset();
			zumbis.get(i).y += cena.getYOffset();
		}
		
	}
	
}
