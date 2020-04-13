package game.Objetos;

public enum TipoReciclavel {
	PAPEL("Papel", "src/resouces/sprites/papel.png"),
	VIDRO("Vidro","src/resouces/sprites/vidro.png"),
	METAL("Metal","src/resouces/sprites/vidro.png"),
	PLÁSTICO("Plástico","src/resouces/sprites/papel.png"),
	ORGÂNICO("Orgânico", "src/resouces/sprites/organico.png");
	
	private String descricao;
	private String urlImagem;
	
	TipoReciclavel(String descricao, String urlImagem) {
		this.descricao = descricao;
		this.urlImagem = urlImagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public static TipoReciclavel random() {
		return TipoReciclavel.values()[Double.valueOf(
				Math.random() * TipoReciclavel.values().length).intValue()];
	}
}
