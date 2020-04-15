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

public class Cenario2 {
	
	private Window janela;
	private Scene cena;
	private Jogador jogador;
	private Keyboard teclado;
	private List<Objeto> arvores;
	private List<Inimigo> inimigos;
	private List<Reciclavel> reciclaveis = new ArrayList<>();
	private List<Lixeira> lixeiras = new ArrayList<>();
	
	public Cenario2(Window window) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile("src/resouces/snc/scenery2.scn");
		jogador = new Jogador(05, 250);
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
			
			showLixeiras();
			showReciclaveis();
			showArvores();
			showinimigos();
			inimigoFinal();
			
			jogador.x += cena.getXOffset();
			jogador.y += cena.getYOffset();
	
			jogador.mostrarEnergia(janela);
			jogador.mostrarMochila(janela);
			
			gameOver();
			vitoria();
			
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
		objects.add(new Objeto("src/resouces/sprites/arvore.png", 200, 450));
		objects.add(new Objeto("src/resouces/sprites/arvore.png", 450, 270));
		objects.add(new Objeto("src/resouces/sprites/arvore.png", 150, 270));
		objects.add(new Objeto("src/resouces/sprites/arvore.png", 50, 350));
		objects.add(new Objeto("src/resouces/sprites/arvore.png", 270, 70));
		objects.add(new Objeto("src/resouces/sprites/arvore.png", 150, 380));
		objects.add(new Objeto("src/resouces/sprites/arvore.png", 170 , 100));
		objects.add(new Objeto("src/resouces/sprites/arvore.png", 1350 , 460 ));
		objects.add(new Objeto("src/resouces/sprites/arvore.png", 380 , 500 ));
		objects.add(new Objeto("src/resouces/sprites/arvore.png", 480 , 100 ));
		objects.add(new Objeto("src/resouces/sprites/arvore.png", 590 , 250 ));
		objects.add(new Objeto("src/resouces/sprites/arvore.png", 900 , 450 ));
		objects.add(new Objeto("src/resouces/sprites/arvore.png", 900, 80 ));
		objects.add(new Objeto("src/resouces/sprites/arvore.png", 1200, 40));
		objects.add(new Objeto("src/resouces/sprites/arvore.png", 1400, 90));
		objects.add(new Objeto("src/resouces/sprites/arvore.png", 1500, 450));
		return objects;
	}
	
	public List<Inimigo> gerandoInimigos(){
		Random gerador = new Random();
		List<Inimigo> inimigos = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			inimigos.add(new Inimigo(gerador.nextInt(1580), 100 + gerador.nextInt(590)));
		}
		return inimigos;
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
		lixeiras.add(new Lixeira("src/resouces/sprites/lixeira.png", 1620, 05, TipoReciclavel.METAL));
		lixeiras.add(new Lixeira("src/resouces/sprites/lixeira.png", 1560, 05, TipoReciclavel.VIDRO));
		lixeiras.add(new Lixeira("src/resouces/sprites/lixeira.png", 1480, 05, TipoReciclavel.ORGÂNICO));
		lixeiras.add(new Lixeira("src/resouces/sprites/lixeira.png", 1400, 05, TipoReciclavel.PAPEL));
		lixeiras.add(new Lixeira("src/resouces/sprites/lixeira.png", 1320, 05, TipoReciclavel.PLÁSTICO));
	}
	
	public  void showLixeiras() {
		for(Lixeira lixeira : lixeiras) {
			lixeira.showObject(cena);
			jogador.depositarReciclavel(lixeira, teclado);
		}
	}
	
	public void inimigoFinal() {
		boolean novoInimigo = true;
		for(Inimigo inimigo : inimigos) {
			if(!inimigo.getMorrer()) {
				novoInimigo = false;
			}
		}
		if(novoInimigo && inimigos.size() == 10) {
			inimigos.add(new Inimigo(300, 300, 5000));
		}
	}
	
	public void vitoria() {
		Integer reciclaveis = 0;
		for(Lixeira lixeira : lixeiras) {
			reciclaveis += lixeira.getReciclaveis().size();
		}
		if(reciclaveis == 11) {
			new Vitoria(janela);
		}
	}
	
	public void gameOver() {
		if(jogador.energia <= 0) {
			new GameOver(janela);
		}
	}
}
