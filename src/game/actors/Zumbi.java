package game.actors;

public class Zumbi  extends Actor{

	
	public Zumbi(int x, int y) {
		super("src/resouces/sprites/zumbi.png", 16);
		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
		this.velocidade = 0.3;
	}
	
	public void perseguir(double x, double y) {
		if(this.x > x && this.y <= y + 50 && this.y >= y - 50) {
			moveTo(x, y, velocidade);
			if(direcao != 1) {
				setSequence(5, 8);
				direcao = 1;
			} movendo = true;
		}
		else if(this.x < x && this.y <= y + 50 && this.y >= -50) {
			moveTo(x, y, velocidade);
			if(direcao != 2) {
				setSequence(9, 12);
				direcao = 2;
			}movendo = true;
		}
		else if(this.y > y) {
			moveTo(x, y, velocidade);
			if(direcao != 4) {
				setSequence(13, 16);
				direcao = 4;
			}movendo = true;
		}
		else if(this.y < y) {
			moveTo(x, y, velocidade);
			if(direcao != 5) {
				setSequence(1, 4);
				direcao = 5;
			}movendo = true;
		}
		if(movendo) {
			update();
			movendo = false;
		}
	}

}