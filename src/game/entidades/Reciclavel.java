package game.entidades;

import java.util.List;

import game.dto.ReciclavelDTO;
import game.entidades.enuns.TipoReciclavel;

public class Reciclavel extends Objeto {
	
	private TipoReciclavel tipo;

	public Reciclavel(String fileName, int x, int y, TipoReciclavel tipo) {
		super(tipo.getUrlImagem(), x, y);
		this.tipo = tipo;
	}
	
	public Reciclavel(ReciclavelDTO obj) {
		super(obj.getUrl(), obj.getX(), obj.getY());
		this.tipo = retornaTipoReciclavel(obj.getTipo());
	}
	
	public TipoReciclavel getTipo() {
		return tipo;
	}

	public void setTipo(TipoReciclavel tipo) {
		this.tipo = tipo;
	}
	
	public static Integer quantidadeTipoReciclavel(List<Reciclavel> reciclaveis, TipoReciclavel tipo ) {
		Integer quantidade = 0;
		for(Reciclavel reciclavel : reciclaveis)
			if(reciclavel.getTipo().getDescricao().equals(tipo.getDescricao())) {
				quantidade += 1;
		}
		return quantidade;
	}
	
	public TipoReciclavel retornaTipoReciclavel(String descricao) {
		for(TipoReciclavel tipo : TipoReciclavel.values()) {
			if(tipo.getDescricao().equals(descricao))
				return tipo;
		}
		return null;
	}
}
