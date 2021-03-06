package br.esig.com.biblioteca.dominio;

import java.util.HashMap;
import java.util.Map;

public enum EstadoConversacao {
	BOM(1), RUIM(2);
	
	private Integer id;
	
	private String denominacao;
	
	@SuppressWarnings("serial")
	public static final Map<Integer, String> descricaoStatus = new HashMap<Integer, String>(){{
		put(BOM.getId(), "BOM");
		put(RUIM.getId(), "RUIM");
	}};
	
	EstadoConversacao(int id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDenominacao() {
		return denominacao;
	}

	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}
}
