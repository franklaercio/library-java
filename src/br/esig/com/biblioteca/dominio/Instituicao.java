package br.esig.com.biblioteca.dominio;

public class Instituicao {
	public String nomeInstituicao;
	
	public String razaoSocial;
	
	public Integer anoFundacao;
	
	public Instituicao() {
		this.nomeInstituicao = "UNEMAT";
		this.razaoSocial = "Ensino";
		this.anoFundacao = 1950;
	}

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Integer getAnoFundacao() {
		return anoFundacao;
	}

	public void setAnoFundacao(Integer anoFundacao) {
		this.anoFundacao = anoFundacao;
	}

}
