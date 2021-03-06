package br.esig.com.biblioteca.dominio;

public class Biblioteca extends Instituicao {
	public String nomeBiblioteca;
	
	public Integer anoCriacao;
	
	public String sigla;
	
	@SuppressWarnings("unused")
	public Biblioteca() {
		Instituicao instituicao = new Instituicao();
		this.nomeBiblioteca = "Biblioteca Central";
		this.anoCriacao = 2001;
		this.sigla = "BC";
	}

	public String getNomeBiblioteca() {
		return nomeBiblioteca;
	}

	public void setNomeBiblioteca(String nomeBiblioteca) {
		this.nomeBiblioteca = nomeBiblioteca;
	}

	public Integer getAnoCriacao() {
		return anoCriacao;
	}

	public void setAnoCriacao(Integer anoCriacao) {
		this.anoCriacao = anoCriacao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	@Override
	public String toString() {
		System.out.println("Nome: " + this.getNomeBiblioteca() + " - " + this.getSigla());
		System.out.println("Instituição: " + this.getNomeInstituicao());
		System.out.println("Ano de Criação: " +this.getAnoCriacao());
		return "";
	}
	
}
