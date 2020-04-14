package game.Objetos;

import java.util.List;

public class Reciclavel extends Objeto {
	
	private TipoReciclavel tipo;

	public Reciclavel(String fileName, int x, int y, TipoReciclavel tipo) {
		super(tipo.getUrlImagem(), x, y);
		this.tipo = tipo;
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
}
