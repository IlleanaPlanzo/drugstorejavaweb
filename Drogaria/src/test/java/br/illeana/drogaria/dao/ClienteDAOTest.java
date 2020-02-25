package br.illeana.drogaria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.illeana.drogaria.domain.Cliente;
import br.illeana.drogaria.domain.Pessoa;

public class ClienteDAOTest {
	
	@Test
	@Ignore
	public void salvar() throws ParseException {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);
		
		Cliente cliente = new Cliente();
		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2015"));
		cliente.setLiberado(true);
		cliente.setPessoa(pessoa);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
		
		System.out.print("Cliente inserido com sucesso");
	}
	
	@Test
	@Ignore
	public void listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.listar();
		
		for(Cliente cliente : resultado) {
			System.out.println("Codigo do Cliente: " + cliente.getCodigo());
			System.out.println("Nome da Pessoa do Cliente: " + cliente.getPessoa().getNome());
			System.out.println("Data de Cadastro do Cliente: " + cliente.getCodigo());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		
		Long codigo = 1L;
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);
		
		if(cliente == null) {
			System.out.println("Nenhum registro encontrado.");
		}else {
			System.out.println("Cliente encontrado: ");
			System.out.println("Codigo do Cliente: " + cliente.getCodigo());
			System.out.println("Nome da Pessoa do Cliente: " + cliente.getPessoa().getNome());
			System.out.println("Data de Cadastro do Cliente: " + cliente.getCodigo());
			
		}
		
	}
	
	@Test
	public void excluir() {
		Long codigo = 1L;
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);
		
		if(cliente == null) {System.out.println("Nenhum registro encontrado.");
		}else {
			clienteDAO.excluir(cliente);
			System.out.println("Cliente excluido: ");
			System.out.println("Codigo do Cliente: " + cliente.getCodigo());
			System.out.println("Nome da Pessoa do Cliente: " + cliente.getPessoa().getNome());
			System.out.println("Data de Cadastro do Cliente: " + cliente.getCodigo());
			
		}
	}

}
