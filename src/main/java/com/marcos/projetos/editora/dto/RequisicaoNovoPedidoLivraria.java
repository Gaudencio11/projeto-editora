package com.marcos.projetos.editora.dto;

import javax.validation.constraints.NotBlank;

import com.marcos.projetos.editora.model.Pedido;
import com.marcos.projetos.editora.model.StatusPedido;




//Aqui nós delimitamos os campos que a livraria pode alterar
public class RequisicaoNovoPedidoLivraria {

    @NotBlank
    private String nomeLivro;
    
	
    private int quantidade;
    @NotBlank
    private String nome_livraria;
    
	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getNome_livraria() {
		return nome_livraria;
	}
	public void setNome_livraria(String nome_livraria) {
		this.nome_livraria = nome_livraria;
	}
	

    public Pedido toPedido(){
		Pedido pedido = new Pedido();

		pedido.setNomeLivro(nomeLivro);
		pedido.setQuantidade(quantidade);
		pedido.setNome_livraria(nome_livraria);
		pedido.setStatus(StatusPedido.FEITO);

		return pedido;
	}

}
