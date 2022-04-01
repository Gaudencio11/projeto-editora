package com.marcos.projetos.editora.controller;

import javax.validation.Valid;

import com.marcos.projetos.editora.dto.RequisicaoAlterarEditora;
import com.marcos.projetos.editora.model.Pedido;
import com.marcos.projetos.editora.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("editora")
public class PedidoEditoraController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping("deletar-pedido/{id}")
    public String deletarPedido(@PathVariable("id") Long id, Model model){
        Pedido pedido = repository.getById(id);

        if(pedido == null){
            model.addAttribute("menssagem", "ESSE ID NÃO EXISTE");
            return"redirect:/";
        }
        
        repository.delete(pedido); 

        return"redirect:/";
    }

    @GetMapping("alterar-pedido/{id}")
	public String alterarPedido(@PathVariable("id") Long id, Model model, RequisicaoAlterarEditora requisicao ){
		Pedido pedido = repository.getById(id);

		//RequisicaoNovoPedido requisicao = new RequisicaoNovoPedido();

		requisicao.setValor_total(pedido.getValor_total());
		requisicao.setStatus(pedido.getStatus());
		

		
		model.addAttribute("pedido",pedido);
		

		

		return"editora/formulario_pedido";
	}

    @RequestMapping("salvar-pedido/{id}")
	public String alterarPedidoSalvar(@Valid RequisicaoAlterarEditora requisicao, BindingResult verificacao, @PathVariable("id") Long id, Model model) {
		
		//Se nosso formulário teve erro nós voltamos para ele , se não ele é redirecionado
		if(verificacao.hasErrors()) {
			return "pedido/update";
			
		}
		//Aqui eu pego os dados que tão nessa requisição e atribuo ao pedido e salvo isso
		Pedido pedido = repository.getById(id);


		pedido.setValor_total(requisicao.getValor_total());
		pedido.setStatus(requisicao.getStatus());
		
		
		repository.save(pedido); 
		
		return "redirect:/";
	}

}
