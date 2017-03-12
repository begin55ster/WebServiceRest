package br.com.jefferson.controller;

import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.jefferson.exceptions.BusinessException;
import br.com.jefferson.http.PessoaHttp;
import br.com.jefferson.interfaceServices.IPessoaRNFacade;
import br.com.jefferson.model.PessoaEntity;

@Path("service")
public class ServicePessoaController {
	
	@EJB
	private IPessoaRNFacade pessoaRN;
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public PessoaHttp busca(@PathParam("id") long id) {
		PessoaHttp pessoa = new PessoaHttp();
		try {
			pessoa = pessoaRN.recuperarPorId(id);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	    return pessoa;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PessoaHttp> TodasPessoas(){
		List<PessoaHttp> pessoas = pessoaRN.listarPessoas();
		return pessoas;
	}

	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response Cadastrar(PessoaHttp pessoa){
		try {
			pessoaRN.gravarPessoa(pessoa);
			URI uri = URI.create("/service/" + pessoa.getSeq());
		return Response.created(uri).build();
		} catch (Exception e) {
			URI uri = URI.create("/service/" + pessoa.getSeq());
		return Response.created(uri).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response Alterar(PessoaHttp pessoa) {
		try {
			pessoaRN.atualizaPessoa(pessoa);
		return Response.ok().build();
		} catch (Exception e) {
		return Response.notModified().build();
		}
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")	
	public Response Excluir(@PathParam("id") long id){
		try {
			pessoaRN.delete(PessoaEntity.class, id);
		return Response.ok().build();
		} catch (Exception e) {
		return Response.notModified().build();
		}
	}
}
