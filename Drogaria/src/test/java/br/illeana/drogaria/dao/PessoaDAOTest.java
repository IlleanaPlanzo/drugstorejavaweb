package br.illeana.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.illeana.drogaria.domain.Cidade;
import br.illeana.drogaria.domain.Pessoa;

public class PessoaDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(new Long("1"));
		
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Fulano de Tal");
		pessoa.setCpf("02357166266");
		pessoa.setRg("7171826");
		pessoa.setRua("Rua Nova");
		pessoa.setNumero(new Short ("10"));
		pessoa.setBairro("Pedreira");
		pessoa.setCep("66083561");
		pessoa.setComplemento("entre tal e tal");
		pessoa.setTelefone("91982769201");
		pessoa.setCelular("91982769201");
		pessoa.setEmail("fulano@hotmail.com");
		pessoa.setCidade(cidade);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);
		
		System.out.println("Pessoa salva com sucesso.");
	}
	
	@Test
	@Ignore
	public void listar() {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();
		
		for(Pessoa pessoa : resultado){
			System.out.println("Codigo da Pessoa: " + pessoa.getCodigo());
			System.out.println("Endereco da Pessoa: " + pessoa.getCep() + ", " + pessoa.getRua() + pessoa.getNumero() + pessoa.getBairro() + pessoa.getComplemento());
			System.out.println("Telefone da Pessoa: " + pessoa.getTelefone());
			System.out.println("Celular da Pessoa: " + pessoa.getCelular());
			System.out.println("RG da Pessoa: " + pessoa.getRg());
			
		}
		
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		
		
		if (pessoa == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Codigo da Pessoa: " + pessoa.getCodigo());
			System.out.println("Endereco da Pessoa: " + pessoa.getCep() + ", " + pessoa.getRua() + pessoa.getNumero() + pessoa.getBairro() + pessoa.getComplemento());
			System.out.println("Telefone da Pessoa: " + pessoa.getTelefone());
			System.out.println("Celular da Pessoa: " + pessoa.getCelular());
			System.out.println("RG da Pessoa: " + pessoa.getRg());
				
			} 
		
	}
	
	@Test
	public void excluir() {
		Long codigo = 2L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		
		if(pessoa == null) {
			System.out.print("Nenhum registro encontrado.");
		}else {
			pessoaDAO.excluir(pessoa);
			System.out.println("Pessoa removida: ");
			System.out.println("Codigo da Pessoa: " + pessoa.getCodigo());
			System.out.println("Endereco da Pessoa: " + pessoa.getCep() + ", " + pessoa.getRua() + pessoa.getNumero() + pessoa.getBairro() + pessoa.getComplemento());
			System.out.println("Telefone da Pessoa: " + pessoa.getTelefone());
			System.out.println("Celular da Pessoa: " + pessoa.getCelular());
			System.out.println("RG da Pessoa: " + pessoa.getRg());
		}
	}

}
