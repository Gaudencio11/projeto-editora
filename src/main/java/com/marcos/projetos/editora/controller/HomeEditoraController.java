package com.marcos.projetos.editora.controller;

import java.util.*;

import javax.validation.Valid;

import com.marcos.projetos.editora.dto.RequisicaoNovaLivraria;
import com.marcos.projetos.editora.model.Livraria;
import com.marcos.projetos.editora.model.Pedido;
import com.marcos.projetos.editora.model.StatusPedido;
import com.marcos.projetos.editora.repository.LivrariaRepository;
import com.marcos.projetos.editora.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class HomeEditoraController {

	@Autowired
    private PedidoRepository pedidoRepository;

	@Autowired
	private LivrariaRepository livrariaRepository;

    @GetMapping
    public String HomeView(Model model){
        
        List<Pedido> pedidos = pedidoRepository.findAll();

        
        model.addAttribute("pedidos", pedidos);


        return "editora/home";
    }

    @GetMapping("/{status}") 
	public String porStatus(@PathVariable("status") String status, Model model) {
		
		//get object by id vai ser basicamente o que vamos fazer aqui
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);

		//Aqui retorno o html
		return "editora/home";
	} 
	
	@GetMapping("adicionar-livraria")
	public String adicionarLivrariaView(RequisicaoNovaLivraria requisicao){

		return "editora/formulario_livraria";
	}

	@PostMapping("salvar-livraria")
    public String salvarLivraria(@Valid RequisicaoNovaLivraria requisicao, BindingResult verificacao, Model model){
        if(verificacao.hasErrors()){
            return"editora/formulario_livraria";
        }

        Livraria livraria = requisicao.toLivraria();
        livrariaRepository.save(livraria);


        return "redirect:/";
    }
}

