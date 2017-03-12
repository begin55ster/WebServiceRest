package br.com.jefferson.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.jefferson.dao.PessoaDao;
import br.com.jefferson.exceptions.BusinessException;
import br.com.jefferson.http.PessoaHttp;
import br.com.jefferson.interfaceServices.IPessoaRNFacade;
import br.com.jefferson.model.PessoaEntity;

@Stateless
public class PessoaRN implements IPessoaRNFacade {
	
	private static final long serialVersionUID = 7239099619457260100L;
	
	@Inject
	private PessoaDao repository;

	@Override
	public List<PessoaHttp> listarPessoas() {
		List<PessoaHttp> pessoas =  new ArrayList<PessoaHttp>();
		List<PessoaEntity> listaEntityPessoas = repository.listarPessoas();
			for (PessoaEntity entity : listaEntityPessoas) {
				pessoas.add(new PessoaHttp(entity.getSeq(), entity.getNome(),entity.getCpf(), entity.getEmail(), entity.getTelefone()));
			}
		return pessoas;
	}

	@Override
	public void gravarPessoa(PessoaHttp pessoaHttp) throws BusinessException {
		PessoaEntity pessoaEntity = new PessoaEntity();
		pessoaEntity.setNome(pessoaHttp.getNome());
		pessoaEntity.setCpf(pessoaHttp.getCpf());
		pessoaEntity.setEmail(pessoaHttp.getEmail());
		pessoaEntity.setTelefone(pessoaHttp.getTelefone());
		repository.gravarPessoa(pessoaEntity);		
	}

	@Override
	public void atualizaPessoa(PessoaHttp pessoaHttp) throws BusinessException {
		PessoaEntity pessoaEntity = new PessoaEntity();
		pessoaEntity.setSeq(pessoaHttp.getSeq());
		pessoaEntity.setNome(pessoaHttp.getNome());
		pessoaEntity.setCpf(pessoaHttp.getCpf());
		pessoaEntity.setEmail(pessoaHttp.getEmail());
		pessoaEntity.setTelefone(pessoaHttp.getTelefone());
		repository.atualizaPessoa(pessoaEntity);
	}

	@Override
	public PessoaHttp recuperarPorId(long codigo) throws BusinessException {
		PessoaHttp pessoa = new PessoaHttp();
		PessoaEntity entity = repository.recuperarPorId(codigo);
			if(entity != null) {
				pessoa = new PessoaHttp(entity.getSeq(), entity.getNome(),entity.getCpf(), entity.getEmail(), entity.getTelefone());
			}
		return pessoa;
	}

	@Override
	public void delete(Class<PessoaEntity> class1, long codigo) throws BusinessException {
		repository.delete(PessoaEntity.class, codigo);
	}
}
