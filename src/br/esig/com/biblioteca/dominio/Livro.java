package br.esig.com.biblioteca.dominio;

public class Livro {
	public String titulo;
	
	public EstadoConversacao estadoConvervacao;
	
	public boolean emprestado;
	
	public Livro() {}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public EstadoConversacao getEstadoConvervacao() {
		return estadoConvervacao;
	}

	public void setEstadoConvervacao(EstadoConversacao estadoConvervacao) {
		this.estadoConvervacao = estadoConvervacao;
	}

	public boolean isEmprestado() {
		return emprestado;
	}

	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

}
