package org.generation.grafeat.model;

import java.sql.Date;

public class VendedorLogin {

	private Long id;
	private String nomeVendedor;
	private String usuario;
	private String senha;
	private String foto;
	private String localidade;
	private Date dataDeNascimento;
	private String tipoDePagamento;
	private String token;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public String getTipoDePagamento() {
		return tipoDePagamento;
	}
	public void setTipoDePagamento(String tipoDePagamento) {
		this.tipoDePagamento = tipoDePagamento;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
