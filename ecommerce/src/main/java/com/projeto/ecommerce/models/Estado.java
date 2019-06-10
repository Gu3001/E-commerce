package com.projeto.ecommerce.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "estados")
public class Estado implements Serializable{
		private static final long serialVersionUID = 1l;
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		private String nome;
		private String sigla;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getSigla() {
			return sigla;
		}
		public void setSigla(String sigla) {
			this.sigla = sigla;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
}
