package org.generation.grafeat.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tb_vendedores")
public class Vendedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome do vendedor não pode ser vazio")
	@Size(min = 4, max = 100, message = "O nome deve conter no mínimo 7 e no máximo 100 caracteres.")
	private String nomeVendedor;
	
	@Schema(example = "email@email.com.br")
	@NotBlank(message = "O email do vendedor não pode ser vazio")
	@Size(min = 7, max = 100, message = "O email deve conter no mínimo 7 e no máximo 100 caracteres.")
	private String usuario;
	
	@NotBlank(message = "A senha do vendedor não pode ser vazio")
	@Size(min = 8, max = 100, message = "A senha deve conter no mínimo 8 e no máximo 100 caracteres.")
	private String senha;
	
	@NotBlank(message = "A foto do vendedor não pode ser vazio")
	@Size(min = 10, max = 250, message = "O link deve conter no mínimo 10 e no máximo 250 caracteres.")
	private String foto;
	
	@Size(min = 5, max = 100, message = "O local deve conter no mínimo 5 e no máximo 100 caracteres.")
	private String localidade;
	
	@NotNull(message = "A data do vendedor não pode ser vazio")
	private LocalDate dataDeNascimento;
	
	@NotBlank(message = "O tipo de pagamento não pode ser vazio")
	private String tipoDePagamento;

	@OneToMany(mappedBy = "vendedor", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("vendedor")
	private List<Produto> produto;
	
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

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getTipoDePagamento() {
		return tipoDePagamento;	
	}

	public void setTipoDePagamento(String tipoDePagamento) {
		this.tipoDePagamento = tipoDePagamento;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
}
