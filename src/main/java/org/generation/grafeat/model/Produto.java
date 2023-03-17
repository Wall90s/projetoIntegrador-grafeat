package org.generation.grafeat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name= "tb_produtos")

public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome do produto não pode ser vazio")
	@Size(min = 3, max = 100, message = "O nome deve conter no mínimo 3 e no máximo 100 caracteres.")
	private String nome;
	
	@NotBlank(message = "A descrição do produto não pode ser vazio")
	@Size(min = 3, max = 1000, message = "A descrição deve conter no mínimo 3 e no máximo 1000 caracteres.")
	private String descricao;
	
	@NotBlank(message = "O preço do produto não pode ser vazio")
	@Size(min = 3, max = 9, message = "O preço deve conter no mínimo 3 e no máximo 9 caracteres.")
	private float preco;

	private String material;
	
	@NotBlank(message = "O tamanho do produto não pode ser vazio")
	@Size(min = 3, max = 100, message = "O tamanho deve conter no mínimo 3 e no máximo 100 caracteres.")
	private String tamanho;
	
	@NotBlank(message = "A quantidade do produto não pode ser vazia")
	@Size(min = 1, max= 4, message = "A quantidade deve conter no mínimo 1 e no máximo 4 caracteres")
	private int quantidade;
	
	
	@NotBlank(message = "A foto do produto não pode ser vazia")
	@Size(min = 3, max = 250, message = "O link deve conter no mínimo 3 e no máximo 250 caracteres")
	private String linkFoto;
	
	
	
	
	public Long getId() {
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


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}


	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	}


	public String getTamanho() {
		return tamanho;
	}


	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public String getLinkFoto() {
		return linkFoto;
	}


	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}

	
	
}
