package br.com.jefferson.dao;

import java.util.List;

import br.com.jefferson.model.PessoaEntity;


public class PessoaDao extends DaoGenerica {

	private static final long serialVersionUID = 2888539673010875916L;

	public void gravarPessoa(PessoaEntity pessoaEntity) {
		save(pessoaEntity);
	}
	
	public List<PessoaEntity> listarPessoas() {
		return findAll(PessoaEntity.class);
	}
	
	public PessoaEntity recuperarPorId(long id) {
		return find(PessoaEntity.class, id);
		
	}
	
	public void atualizaPessoa(PessoaEntity pessoaEntity) {
		merge(pessoaEntity);
	}
	
	public void excluir(long id) {
		 delete(PessoaEntity.class, id);
	}
}
