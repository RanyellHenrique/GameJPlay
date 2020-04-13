package game.Objects;

public class ObjetoReciclavel extends Objeto {
	
	private TipoReciclavel tipo;

	public ObjetoReciclavel(String fileName, int x, int y, TipoReciclavel tipo) {
		super(tipo.getUrlImagem(), x, y);
		this.tipo = tipo;
	}
	
	public TipoReciclavel getTipo() {
		return tipo;
	}

	public void setTipo(TipoReciclavel tipo) {
		this.tipo = tipo;
	}

}
