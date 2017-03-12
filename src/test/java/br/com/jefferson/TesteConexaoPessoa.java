package br.com.jefferson;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jefferson.dao.PessoaDao;
import br.com.jefferson.model.PessoaEntity;

public class TesteConexaoPessoa {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;

	public static void main(String[] args) {
		
		 emf = Persistence.createEntityManagerFactory("teste_pu");
	     em = emf.createEntityManager();
	     em.getTransaction().begin();
//	     teste();
	     PessoaEntity pessoa = buscaPessoa(1);
	     System.out.println(pessoa.getNome());
		
	}
	
	public static void teste() {
	    
	    PessoaEntity pessoa = new PessoaEntity();
	    pessoa.setNome("Joao Barbosa Amorim");
	    pessoa.setCpf("876456345-12");
	    pessoa.setEmail("joao_barbosa@gmail.com");
	    pessoa.setTelefone("33754765");
	    
	    em.persist(pessoa);

	    em.getTransaction().commit();
	    
	    em.close();
	}
	
	public static PessoaEntity buscaPessoa(long id) {
		
		PessoaDao pessoaDao = new PessoaDao();
		PessoaEntity pessoa = pessoaDao.recuperarPorId(id);
		
		return pessoa;
	}
	

}
