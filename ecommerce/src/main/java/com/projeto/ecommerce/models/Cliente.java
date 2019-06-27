package com.projeto.ecommerce.models;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa implements Serializable{
	public static final long SerialVersionUID = 1L;
	
	private String statusCliete;
	private String rg;
	private String cpf;
	private String dtNasc;
	
	public String getStatusCliete() {
		return statusCliete;
	}
	public void setStatusCliete(String statusCliete) {
		this.statusCliete = statusCliete;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}
	public static long getSerialversionuid() {
		return SerialVersionUID;
	}
	
	
	
}
