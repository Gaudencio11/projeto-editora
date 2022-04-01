package com.marcos.projetos.editora.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


import com.marcos.projetos.editora.model.StatusPedido;

//Aqui nós delimitamos os campos que a editora pode alterar
public class RequisicaoAlterarEditora {

    //@NotBlank
    private double valor_total;
    
    //@NotBlank
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}
    
    
}
