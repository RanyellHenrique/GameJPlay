package game.cenarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.Objetos.Lixeira;
import game.Objetos.Objeto;
import game.Objetos.Reciclavel;
import game.Objetos.TipoReciclavel;
import game.atores.Inimigo;
import game.atores.Jogador;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Window;

public class Cenario1 {
	
	private Window janela;
	private Scene cena;
	private Jogador jogador;
	private Keyboard teclado;
	private List<Objeto> arvores;
	private List<Inimigo> inimigos;
	private List<Reciclavel> reciclaveis = new ArrayList<>();
	private Lixeira lixeira;
	
	public Cenario1(Window window) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile("src/resouces/snc/scenery1.scn");
		jogador = new Jogador(650, 300);
		//Audio.play("src/audios/musica.wav");
		arvores = gerandoArvores();
		inimigos = gerandoInimigos();
		gerandoLixeiras();
		teclado = janela.getKeyboard();
		run();
	}
	
	private void run() {
		while(true) {
			//cena.draw();
			jogador.mover(janela, teclado);
			jogador.caminho(cena);
			cena.moveScene(jogador);
			
			lixeira.draw();
			showReciclaveis();
			showArvores();
			showinimigos();
			
			lixeira.x += cena.getXOffset();
			lixeira.y += cena.getYOffset();
			
			jogador.x += cena.getXOffset();
			jogador.y += cena.getYOffset();
			jogador.depositarReciclavel(lixeira, teclado);

			jogador.mostrarEnergia(janela);
			jogador.mostrarMochila(janela);
			
			janela.update();
		}
	}
	
	public void showArvores() {
		for(int i=0; i<arvores.size(); i++) {
			if(jogador.y - 35 > arvores.get(i).y) {
				arvores.get(i).showObject(cena);
			}
		}
				
		jogador.draw();
		for (int i = 0; i < inimigos.size(); i++) {
			inimigos.get(i).draw();
		}
		
		for(int i=0; i<arvores.size(); i++) {
			if(jogador.y - 35 <= arvores.get(i).y) {
				arvores.get(i).showObject(cena);
			}
		}
	}
	
	public List<Objeto> gerandoArvores(){
		List<Objeto> objects = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			if(i%2 == 0)
				objects.add(new Objeto("src/resouces/sprites/arvore.png", 150 * (1 * i), 400 + 20 * i));
			else
				objects.add(new Objeto("src/resouces/sprites/arvore.png", 200 * (1 * i), 350 + 10 * i));
		}
		return objects;
	}
	
	public List<Inimigo> gerandoInimigos(){
		Random gerador = new Random();
		List<Inimigo> zumbs = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			zumbs.add(new Inimigo(gerador.nextInt(1580), 100 + gerador.nextInt(590)));
		}
		return zumbs;
	}
	
	public  void showinimigos() {
		Inimigo inimigo;
		for(int i=0; i<inimigos.size(); i++) {
			inimigo = inimigos.get(i);
			inimigo.perseguir(jogador.x, jogador.y);
			inimigo.caminho(cena);
			jogador.atirar(janela, cena, teclado, inimigo);
			inimigo.morrer(cena, reciclaveis);
			inimigo.atacar(jogador);
			inimigo.x += cena.getXOffset();
			inimigo.y += cena.getYOffset();
		}	
	}
	
	
	public void showReciclaveis() {
		Reciclavel reciclavel;
		for (int i = 0; i < reciclaveis.size(); i++) {
			reciclavel = reciclaveis.get(i);
			reciclavel.showObject(cena);
			jogador.coletarReciclavel(reciclavel, teclado);
		}
	}
	
	public void gerandoLixeiras(){
		lixeira = new Lixeira("src/resouces/sprites/lixeira.png", 300, 200, TipoReciclavel.METAL);
	}
	
}