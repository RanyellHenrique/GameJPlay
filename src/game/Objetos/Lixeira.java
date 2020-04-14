package game.Objetos;

import java.util.ArrayList;
import java.util.List;

public class Lixeira  extends Objeto{
	
	private TipoReciclavel tipo;
	private List<Reciclavel> reciclaveis = new ArrayList<>();

	public Lixeira(String fileName, int x, int y, TipoReciclavel tipo) {
		super(fileName, x, y);
		this.tipo = tipo;
	}

	public TipoReciclavel getTipo() {
		return tipo;
	}

	public void setTipo(TipoReciclavel tipo) {
		this.tipo = tipo;
	}	
	
	public List<Reciclavel> getReciclaveis() {
		return reciclaveis;
	}

	public void setReciclaveis(List<Reciclavel> reciclaveis) {
		this.reciclaveis = reciclaveis;
	}
	
	public boolean addReciclavel(Reciclavel reciclavel) {
		if(reciclavel.getTipo().getDescricao().equals(tipo.getDescricao())) {
			this.reciclaveis.add(reciclavel);
			return true;
		}
		return false;
	}

}
