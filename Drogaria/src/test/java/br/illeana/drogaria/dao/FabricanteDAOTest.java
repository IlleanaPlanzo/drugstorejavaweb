package br.illeana.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.illeana.drogaria.domain.Fabricante;

public class FabricanteDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Teste");
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
		
	}
	
	@Test
	@Ignore
	public void listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();
		
		System.out.println("Total de Registros Ecnontrados: " + resultado.size());
		
		for(Fabricante fabricante : resultado) {
			System.out.println(fabricante.getDescricao()); 
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if (fabricante == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println(fabricante.getDescricao()); 
		}
		
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante == null) {
			System.out.println("Nenhum registro encontrado.");
		}else {
			fabricanteDAO.excluir(fabricante);
			System.out.println("Registro removido:");
			System.out.println(fabricante.getDescricao());
		}
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 2L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante == null) {
			System.out.println("Nenhum registro encontrado.");
			
		}else {
			System.out.println("Registro editado - Antes:");
			System.out.println(fabricante.getDescricao());
			
			fabricante.setDescricao("Teste editar");
			fabricanteDAO.editar(fabricante);
			
			System.out.println("Registro editado - Depois:");
			System.out.println(fabricante.getDescricao());
		}

	}
}
