package br.esig.com.biblioteca.dominio;

public class Emprestimo {
	public Aluno aluno;
	
	public Livro livro;
	
	public boolean atrasado;
	
	public Emprestimo() {}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public boolean isAtrasado() {
		return atrasado;
	}

	public void setAtrasado(boolean atrasado) {
		this.atrasado = atrasado;
	}

}
