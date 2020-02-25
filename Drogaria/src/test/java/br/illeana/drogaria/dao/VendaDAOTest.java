package br.illeana.drogaria.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.illeana.drogaria.domain.Cliente;
import br.illeana.drogaria.domain.Funcionario;
import br.illeana.drogaria.domain.Venda;

public class VendaDAOTest {
	
	@Test
	@Ignore
	public void salvar() throws ParseException {
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(new Long("1"));
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(new Long("1"));
		
		
		Venda venda = new Venda();
		venda.setHorario(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2015"));
		venda.setFuncionario(funcionario);
		venda.setCliente(cliente);
		venda.setPrecoTotal(new BigDecimal("30.22"));
		
		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.salvar(venda);
		
		System.out.println("Produto salvo com sucesso.");
	}
	
	@Test
	@Ignore
	public void listar() {
		
		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> resultado = vendaDAO.listar();
		
		for(Venda venda : resultado) {
			System.out.println("Codigo da Venda: " + venda.getCodigo());
			System.out.println("Cliente da Venda " + venda.getCliente().getPessoa().getNome());
			System.out.println("Horario da Venda " + venda.getHorario());
			System.out.println("Preço Total da Venda: " + venda.getPrecoTotal());
			
		}
		
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigo);
		
		if(venda == null) {
			System.out.println("Nenhum registro encontrado");
			
		}else {
			System.out.println("Codigo da Venda: " + venda.getCodigo());
			System.out.println("Cliente da Venda " + venda.getCliente().getPessoa().getNome());
			System.out.println("Horario da Venda " + venda.getHorario());
			System.out.println("Preço Total da Venda: " + venda.getPrecoTotal());
			
		}
		
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigo);
		
		if(venda == null) {
			System.out.println("Nenhum registro encontrado");
			
		}else {
			vendaDAO.excluir(venda);
			System.out.println("Codigo da Venda: " + venda.getCodigo());
			System.out.println("Cliente da Venda " + venda.getCliente().getPessoa().getNome());
			System.out.println("Horario da Venda " + venda.getHorario());
			System.out.println("Preço Total da Venda: " + venda.getPrecoTotal());
			
		}
	}

}
