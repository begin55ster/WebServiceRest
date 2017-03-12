package br.com.jefferson.http;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;

@XmlRootElement // estamos dizendo que Carrinho vai ser Serializable pelo JAXB
@XmlAccessorType(XmlAccessType.FIELD) // todos os campos serao Serializable
public class PessoaHttp {
	
	private long seq;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;

	public PessoaHttp(){
 
	}
 
	public PessoaHttp(long seq, String nome, String cpf, String email, String telefone) {
		this.seq = seq;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		
	}
	
	
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String toJson() {
		return new Gson().toJson(this);
	}
	
//	public String toXML() {
//	    return new XStream().toXML(this);
//	}

}
