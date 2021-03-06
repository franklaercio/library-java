package br.esig.com.biblioteca.dominio;

import java.util.HashMap;
import java.util.Map;

public enum SituacaoAluno {
	ATIVO(1), RETIDO(2);
	
	private Integer id;
	
	private String denominacao;
	
	@SuppressWarnings("serial")
	public static final Map<Integer, String> descricaoStatus = new HashMap<Integer, String>(){{
		put(ATIVO.getId(), "ATIVO");
		put(RETIDO.getId(), "RETIDO");
	}};
	
	SituacaoAluno(int id) {
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
