package br.illeana.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.illeana.drogaria.domain.Estado;

public class EstadoDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("Sao Paulo");
		estado.setSigla("SP");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}
	@Test
	@Ignore
	public void listar(){
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();
		
		System.out.println("Total de Registros Ecnontrados: " + resultado.size());
		
		for(Estado estado : resultado) {
			System.out.println(estado.getSigla() + " - " + estado.getNome()); 
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 2L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if (estado == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println(estado.getSigla() + " - " + estado.getNome()); 
		}
		
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null) {
			System.out.println("Nenhum registro encontrado.");
		}else {
			estadoDAO.excluir(estado);
			System.out.println("Registro removido:");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
		
	}
	@Test
	public void editar(){
		Long codigo = 2L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null) {
			System.out.println("Nenhum registro encontrado.");
			
		}else {
			System.out.println("Registro editado - Antes:");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
			
			estado.setNome("Minas Gerais");
			estado.setSigla("MI");
			estadoDAO.editar(estado);
			
			System.out.println("Registro editado - Depois:");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
		
		
	}
	

}
