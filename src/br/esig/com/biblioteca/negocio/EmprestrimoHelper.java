package br.esig.com.biblioteca.negocio;

import java.util.List;

import br.esig.com.biblioteca.dominio.Aluno;
import br.esig.com.biblioteca.dominio.Emprestimo;
import br.esig.com.biblioteca.dominio.Livro;
import br.esig.com.biblioteca.dominio.SituacaoAluno;

public class EmprestrimoHelper {
	
	public static boolean isPossivelRealizarEmprestimo(String nomeALuno, String titulo, List<Aluno> alunos, List<Livro> livros) {
		if(!alunos.isEmpty()) {
			for (Aluno discente : alunos) {
				if(!nomeALuno.equals(discente.getNome())) {
					System.out.println("Não é possível realizar o empréstimo, pois o discente não existe!");
					
					return false;
				}else if(nomeALuno.equals(discente.getNome()) && discente.getSituacao() == SituacaoAluno.RETIDO) {
					System.out.println("Não é possível realizar o empréstimo, pois o discente está retido!");
					
					return false;
				}
			}
		}
		
		if(!livros.isEmpty()) {
			for (Livro livro : livros) {
				if(!titulo.equals(livro.getTitulo())) {
					System.out.println("Não é possível realizar o empréstimo, pois o livro não existe!");
					
					return false;
				}else if(titulo.equals(livro.getTitulo()) && livro.isEmprestado()) {
					System.out.println("Não é possível realizar o empréstimo, pois o livro está emprestado!");
					
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static Emprestimo realizarEmprestimo(String nomeALuno, String titulo, List<Aluno> alunos, List<Livro> livros) {
		Emprestimo emprestimo = new Emprestimo();
		Aluno alunoEmprestado = null;
		Livro livroEmprestado = null;
		
		if(!alunos.isEmpty()) {
			for (Aluno discente : alunos) {
				if(nomeALuno.equals(discente.getNome())) {
					alunoEmprestado = discente;
				}
			}
		}
		
		if(!livros.isEmpty()) {
			for (Livro livro : livros) {
				if(titulo.equals(livro.getTitulo())) {
					livro.setEmprestado(Boolean.TRUE);
					livroEmprestado = livro;
				}
			}
		}
		
		emprestimo.setAluno(alunoEmprestado);
		emprestimo.setLivro(livroEmprestado);
		emprestimo.setAtrasado(Boolean.FALSE);
		
		System.out.println("Empréstimo realizado com sucesso!");
		
		return emprestimo;
	}
	
	public static void realizarDevolucao(List<Emprestimo> emprestimos, List<Livro> livros, String titulo) {
		if(!emprestimos.isEmpty()) {
			Livro livroEmprestado = null;
			
			for (Emprestimo emprestimo : emprestimos) {
				if(titulo.equals(emprestimo.getLivro().getTitulo())) {
					emprestimo.getLivro().setEmprestado(!emprestimo.getLivro().isEmprestado());
					livroEmprestado = emprestimo.getLivro();
				}
			}
			
			for (Livro livro : livros) {
				if(livroEmprestado.getTitulo().equals(livro.getTitulo())) {
					livro.setEmprestado(!livro.isEmprestado());
				}
			}
		}
	}
}
