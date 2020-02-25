package br.illeana.drogaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.illeana.drogaria.domain.Fabricante;
import br.illeana.drogaria.domain.Produto;

public class ProdutoDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(new Long("1"));
		
		
		Produto produto = new Produto();
		produto.setDescricao("Cataflan 50mg com 20 Comprim");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("13.70"));
		produto.setQuantidade(new Short("7"));
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
		
		System.out.println("Produto salvo com sucesso.");
	}
	
	@Test
	@Ignore
	public void listar() {
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();
		
		for(Produto produto : resultado){
			System.out.println("Codigo do Produto: " + produto.getCodigo());
			System.out.println("Descrição do Produto: " + produto.getDescricao());
			System.out.println("Preço do Produto: " + produto.getPreco());
			System.out.println("Quantidade do Produto: " + produto.getQuantidade());
			System.out.println("Fabricante do Produto: " + produto.getFabricante().getDescricao());
			
		}
		
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);
		
		
		if (produto == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
				System.out.println("Codigo do Produto: " + produto.getCodigo());
				System.out.println("Descrição do Produto: " + produto.getDescricao());
				System.out.println("Preço do Produto: " + produto.getPreco());
				System.out.println("Quantidade do Produto: " + produto.getQuantidade());
				System.out.println("Fabricante do Produto: " + produto.getFabricante().getDescricao());
				
			} 
		
	}
	
	@Test
	public void excluir() {
		Long codigo = 2L;
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);
		
		if(produto == null) {
			System.out.print("Nenhum registro encontrado.");
		}else {
			produtoDAO.excluir(produto);
			System.out.println("Produto removido: ");
			System.out.println("Codigo do Produto: " + produto.getCodigo());
			System.out.println("Descrição do Produto: " + produto.getDescricao());
			System.out.println("Preço do Produto: " + produto.getPreco());
			System.out.println("Quantidade do Produto: " + produto.getQuantidade());
			System.out.println("Fabricante do Produto: " + produto.getFabricante().getDescricao());
			
		}
	}

}
