package game.Objetos;

import java.util.ArrayList;
import java.util.List;

import game.dto.LixeiraDTO;

public class Lixeira  extends Objeto{
	private TipoReciclavel tipo;
	private List<Reciclavel> reciclaveis = new ArrayList<>();

	public Lixeira(String fileName, int x, int y, TipoReciclavel tipo) {
		super(fileName, x, y);
		this.tipo = tipo;
	}
	
	public Lixeira(LixeiraDTO obj) {
		super(obj.getUrl(), obj.getX(), obj.getY());
		this.tipo = retornaTipoReciclavel(obj.getTipo());
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
	
	public boolean tipoReciclavel(Reciclavel reciclavel) {
		if(reciclavel.getTipo().getDescricao().equals(tipo.getDescricao()))
			return true;
		return false;
	}
	
	public void addReciclavel(Reciclavel reciclavel) {
		this.reciclaveis.add(reciclavel);
	}
	
	public TipoReciclavel retornaTipoReciclavel(String descricao) {
		for(TipoReciclavel tipo : TipoReciclavel.values()) {
			if(tipo.getDescricao().equals(descricao))
				return tipo;
		}
		return null;
	}
}
