package br.com.jefferson.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.jefferson.dao.BaseEntity;
	
	@Entity
	@Table(name = "Pessoa")
	public class PessoaEntity extends BaseEntity<Serializable> implements Serializable {
		
		private static final long serialVersionUID = -1836084004244200962L;
		
		public PessoaEntity() {
			
		}
		
		private long seq;
		private String nome;
		private String cpf;
		private String email;
		private String telefone;
		
		
		@Id
		@SequenceGenerator( name = "PESSOA_ID", sequenceName = "PESSOA_SEQUENCE", allocationSize = 1 )
		@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "PESSOA_ID" )
		@Column( name = "CODIGO", nullable = false )
		public long getSeq() {
			return seq;
		}
		
		public void setSeq(long seq) {
			this.seq = seq;
		}
		
		@Column(name = "NOME")
		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		@Column(name = "CPF")
		public String getCpf() {
			return cpf;
		}
		
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		
		@Column(name = "EMAIL")
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		@Column(name = "TELEFONE")
		public String getTelefone() {
			return telefone;
		}
		
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + (int) (seq ^ (seq >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!super.equals(obj)) {
				return false;
			}
			if (!(obj instanceof PessoaEntity)) {
				return false;
			}
			PessoaEntity other = (PessoaEntity) obj;
			if (seq != other.seq) {
				return false;
			}
			return true;
		}


		@Override
		@Transient
		public void setId(Serializable id) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		@Transient          
		public Serializable getId() {
			return seq;
		}		
	
}
