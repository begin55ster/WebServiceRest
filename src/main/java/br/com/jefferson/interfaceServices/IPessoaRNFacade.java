package br.com.jefferson.interfaceServices;

import java.io.Serializable;
import java.util.List;

import br.com.jefferson.exceptions.BusinessException;
import br.com.jefferson.http.PessoaHttp;
import br.com.jefferson.model.PessoaEntity;

public interface IPessoaRNFacade extends Serializable {
	
	public List<PessoaHttp> listarPessoas() ;

	public void gravarPessoa(PessoaHttp pessoaHttp) throws BusinessException ;

	public void atualizaPessoa(PessoaHttp pessoaHttp) throws BusinessException;

	public PessoaHttp recuperarPorId(long codigo) throws BusinessException;

	public void delete(Class<PessoaEntity> class1, long codigo) throws BusinessException;

}
