package br.illeana.drogaria.dao;

import java.text.SimpleDateFormat;
import java.util.List;
import java.text.ParseException;

import org.junit.Ignore;
import org.junit.Test;

import br.illeana.drogaria.domain.Funcionario;
import br.illeana.drogaria.domain.Pessoa;

public class FuncionarioDAOTest {
	
	@Test
	@Ignore
	public void salvar() throws ParseException {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(new Long("1"));
		
		Funcionario funcionario = new Funcionario();
		funcionario.setCarteiraTrabalho("123123123");
		funcionario.setDataAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2015"));
		funcionario.setPessoa(pessoa);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.salvar(funcionario);
	}
	
	@Test
	@Ignore
	public void listar() {
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> resultado = funcionarioDAO.listar();
		
		for(Funcionario funcionario : resultado) {
			System.out.println("Codigo do Funcionario: " + funcionario.getCodigo());
			System.out.println("Carteira do Funcionario: " + funcionario.getCarteiraTrabalho());
			System.out.println("Admissão do Funcionario: " + funcionario.getDataAdmissao());
			System.out.println("Nome do Funcionario: " + funcionario.getPessoa().getNome());
		}
		
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigo);
		
		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado.");
		}else {
			System.out.println("Funcionario encontrado: ");
			System.out.println("Codigo do Funcionario: " + funcionario.getCodigo());
			System.out.println("Carteira do Funcionario: " + funcionario.getCarteiraTrabalho());
			System.out.println("Admissão do Funcionario: " + funcionario.getDataAdmissao());
			System.out.println("Nome do Funcionario: " + funcionario.getPessoa().getNome());
		}
		
	}
	
	@Test
	public void excluir() {
		Long codigo = 2L;
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigo);
		
		if(funcionario == null) {
			System.out.println("Nenhum registro encontrado.");
		}else {
			funcionarioDAO.excluir(funcionario);
			System.out.println("Funcionario removido: ");
			System.out.println("Codigo do Funcionario: " + funcionario.getCodigo());
			System.out.println("Carteira do Funcionario: " + funcionario.getCarteiraTrabalho());
			System.out.println("Admissão do Funcionario: " + funcionario.getDataAdmissao());
			System.out.println("Nome do Funcionario: " + funcionario.getPessoa().getNome());
			
		}
	}

}
