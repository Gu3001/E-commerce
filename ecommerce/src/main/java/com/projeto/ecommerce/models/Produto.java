package com.projeto.ecommerce.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable{
	private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private String qtdest;
	private String qtdemin;
	private Double precoVenda;
	
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getQtdest() {
		return qtdest;
	}
	public void setQtdest(String qtdest) {
		this.qtdest = qtdest;
	}
	public String getQtdemin() {
		return qtdemin;
	}
	public void setQtdemin(String qtdemin) {
		this.qtdemin = qtdemin;
	}
	public Double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}
	public static long getSerialversionuid() {
		return SerialVersionUID;
	}
	
}
