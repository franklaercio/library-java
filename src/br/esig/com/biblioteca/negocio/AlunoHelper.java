package br.esig.com.biblioteca.negocio;

import java.util.Scanner;

import br.esig.com.biblioteca.dominio.Aluno;

public class AlunoHelper {
	
	public static boolean isPossivelCadastrarAluno(Aluno aluno) {
		if(aluno.getNome().length() > 3 && aluno.getMatricula() != null) {
			System.out.println("Discente cadastrado com sucesso!");
			
			return true;
		}
		
		System.out.println("Não é possível cadastrar um discente!");
		
		return false;
	} 
	
	public static void exibirDadosAluno(Aluno aluno) {
		if(aluno != null) {
			System.out.println(aluno.getNome() + " -" + aluno.getMatricula() + " - " + aluno.getSituacao());
		}
	}
	
	public static Aluno cadastrarAluno(Scanner teclado) {
		Aluno aluno = new Aluno();
		
		System.out.print("Informe o nome o discente: ");
		aluno.setNome(teclado.nextLine());
		
		System.out.print("Informe a matricula do discente: ");
		aluno.setMatricula(teclado.nextLong());
		
		return aluno;
	}
}
