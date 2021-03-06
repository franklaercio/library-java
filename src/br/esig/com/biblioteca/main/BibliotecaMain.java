package br.esig.com.biblioteca.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import br.esig.com.biblioteca.dominio.Aluno;
import br.esig.com.biblioteca.dominio.Biblioteca;
import br.esig.com.biblioteca.dominio.Emprestimo;
import br.esig.com.biblioteca.dominio.EstadoConversacao;
import br.esig.com.biblioteca.dominio.Livro;
import br.esig.com.biblioteca.dominio.SituacaoAluno;
import br.esig.com.biblioteca.negocio.AlunoHelper;
import br.esig.com.biblioteca.negocio.EmprestrimoHelper;
import br.esig.com.biblioteca.negocio.LivroHelper;

public class BibliotecaMain {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		List<Aluno> alunos = new ArrayList<Aluno>();
		List<Livro> livros = new ArrayList<Livro>();
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		
		boolean sair = false;
		
		String operacao = "";
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("*---------------------------------------*");
		System.out.println("| Bem Vindo ao Sistema de Biblioteca!     |");
		System.out.println("*---------------------------------------*");
		
		try {
			do {
				System.out.println("*----------------------------------------*");
				System.out.println("| 00 - SAIR                              |");
				System.out.println("| 01 - EXIBIR DADOS DA BIBLIOTECA        |");
				System.out.println("| 02 - ADICIONAR ALUNO                   |");
				System.out.println("| 03 - EXIBIR TODOS OS ALUNOS            |");
				System.out.println("| 04 - EXIBIR TOTAL DE ALUNOS            |");
				System.out.println("| 05 - EXIBIR TOTAL DE ALUNOS RETIDOS    |");
				System.out.println("| 06 - ADICIONAR LIVRO                   |");
				System.out.println("| 07 - EXIBIR TODOS OS LIVROS            |");
				System.out.println("| 08 - EXIBIR LIVROS EMPRESTADOS         |");
				System.out.println("| 09 - EXIBIR TOTAL DE LIVROS            |");
				System.out.println("| 10 - EXIBIR LIVROS ORDENADOS           |");
				System.out.println("| 11 - EXIBIR LIVROS RECENTES            |");
				System.out.println("| 12 - REALIZAR EMPRÉSTIMO               |");
				System.out.println("| 13 - TOTAL DE LIVROS EMPRESTADOS       |");
				System.out.println("| 14 - REALIZAR DEVOLUÇÃO                |");
				System.out.println("*----------------------------------------*");
				System.out.print("Informe a operação: ");
				operacao = teclado.nextLine();
				
				switch (operacao) {
				case "0":
					System.out.println("OBRIGADO!");
					sair = true;
					
					break;
				case "1":
					biblioteca.toString();
					break;
				case "2":
					Aluno aluno = AlunoHelper.cadastrarAluno(teclado);
					
					if(AlunoHelper.isPossivelCadastrarAluno(aluno)) {
						alunos.add(aluno);
					}
					
					break;
				case "3":
					if(!alunos.isEmpty()) {
						for (Aluno discente : alunos) {
							AlunoHelper.exibirDadosAluno(discente);
						}
					}else {
						System.out.println("Não há discentes cadastrados!");
					}
					
					break;
				case "4":
					System.out.println("O total de alunos é: " + alunos.size());
					break;
				case "5":
					int quantidadeAlunosRetidos = 0;
					
					if(!alunos.isEmpty()) {
						for (Aluno discente : alunos) {
							if(discente.getSituacao() == SituacaoAluno.RETIDO) {
								quantidadeAlunosRetidos++;
							}
						}
					}
					
					System.out.println("A quantidade de alunos retidos é: " + quantidadeAlunosRetidos);

					break;
				case "6":
					Livro livro = new Livro();
					System.out.print("Informe o título do livro: ");
					livro.setTitulo(teclado.nextLine());
					
					System.out.print("Informe o estado de conservação do livro (1 - BOM) ou (2 - RUIM): ");
					int situacao = teclado.nextInt();
					if(situacao == EstadoConversacao.BOM.getId()) {
						livro.setEstadoConvervacao(EstadoConversacao.BOM);
					}else if(situacao == EstadoConversacao.RUIM.getId()) {
						livro.setEstadoConvervacao(EstadoConversacao.RUIM);
					}
					
					if(LivroHelper.isPossivelCadastrarLivro(livro)) {
						livros.add(livro);
					}
					
					break;
				case "7":
					if(!livros.isEmpty()) {
						for (Livro livroCadastrado : livros) {
							LivroHelper.exibirDadosLivro(livroCadastrado);
						}
					}
					
					break;
				case "8":
					if(!livros.isEmpty()) {
						for (Livro livro2 : livros) {
							if(!livro2.isEmprestado()) {
								LivroHelper.exibirDadosLivro(livro2);
							}
						}
					}
					
					break;
				case "9":
					System.out.println("O total de livros é: " + livros.size());
					break;
				case "10":	
					Collection<String> livrosOrdenados = new TreeSet<String>();
					
					if(!livros.isEmpty()) {
						for (int i = 0; i < livros.size(); i++) {
							livrosOrdenados.add(livros.get(i).getTitulo());
						}
					}
					
					for (String titulo : livrosOrdenados) {
						System.out.println(titulo);
					}
					
					break;
				case "11":
					List<String> livrosRecentes = new ArrayList<String>();
					
					if(!livros.isEmpty()) {
						for (int i = 0; i < livros.size(); i++) {
							livrosRecentes.add(livros.get(i).getTitulo());
						}
					}
					
					Collections.reverse(livrosRecentes);
					
					for (String titulo : livrosRecentes) {
						System.out.println(titulo);
					}
					
					break;
				case "12":
					System.out.print("Informe o nome do discente: ");
					String nomeDiscente = teclado.nextLine();
					
					System.out.print("Informe o título do livro: ");
					String titulo = teclado.nextLine();
					
					if(EmprestrimoHelper.isPossivelRealizarEmprestimo(nomeDiscente, titulo, alunos, livros)) {
						Emprestimo emprestimo = EmprestrimoHelper.realizarEmprestimo(nomeDiscente, titulo, alunos, livros);
						
						emprestimos.add(emprestimo);
					}
					
					break;
				case "13":
					System.out.println("O total de empréstimos é: " + emprestimos.size());
					break;
				case "14":
					System.out.print("Informe o título do livro: ");
					String tituloEmprestado = teclado.nextLine();
					
					EmprestrimoHelper.realizarDevolucao(emprestimos, livros, tituloEmprestado);
					
					break;	
				default:
					break;
				}
			}while(!sair);
		}finally {
			teclado.close();
		}
	}

}
