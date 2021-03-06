package br.esig.com.biblioteca.negocio;

import br.esig.com.biblioteca.dominio.Livro;

public class LivroHelper {
	
	public static boolean isPossivelCadastrarLivro(Livro livro) {
		if(livro.getTitulo().length() > 3) {
			System.out.println("Livro criado com sucesso!");
			
			return true;
		}
		
		System.out.println("Não foi cadastrar o livro!");
		
		return false;
	}
	
	public static void exibirDadosLivro(Livro livro) {
		if(livro != null) {
			System.out.println(livro.getTitulo() + " - " + livro.getEstadoConvervacao());
		}
	}
}
