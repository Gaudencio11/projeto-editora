package com.marcos.projetos.editora.dto;

import javax.validation.constraints.NotBlank;

import com.marcos.projetos.editora.model.Livraria;

public class RequisicaoNovaLivraria {

    @NotBlank
    private String nome;
    @NotBlank
    private String cnpj;
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

    public Livraria toLivraria(){
        Livraria livraria = new Livraria();

        livraria.setCnpj(cnpj);
        livraria.setNome(nome);

        return livraria;
    }
}
