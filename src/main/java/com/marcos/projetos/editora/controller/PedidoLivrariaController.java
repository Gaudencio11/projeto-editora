package com.marcos.projetos.editora.controller;

import javax.validation.Valid;
import java.util.*;
import com.marcos.projetos.editora.dto.RequisicaoNovoPedidoLivraria;
import com.marcos.projetos.editora.model.Pedido;
import com.marcos.projetos.editora.model.Livraria;
import com.marcos.projetos.editora.repository.LivrariaRepository;
import com.marcos.projetos.editora.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("livraria-pedidos")
public class PedidoLivrariaController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private LivrariaRepository livrariaRepository;



    @GetMapping("criar-pedido")
    public String createPedido(RequisicaoNovoPedidoLivraria requisicao, Model model){
        List<Livraria> livrarias = livrariaRepository.findAll();
        List<String> nomeDasLivrarias = new ArrayList<String>(); 
        for(Livraria livraria:livrarias){
            nomeDasLivrarias.add(livraria.getNome());
        }

        model.addAttribute("nomeDasLivrarias",nomeDasLivrarias);
        
        return"livraria/formulario_pedido";
    }

    @PostMapping("salvar-pedido")
    public String salvarPedido(@Valid RequisicaoNovoPedidoLivraria requisicao, BindingResult verificacao, Model model){
        if(verificacao.hasErrors()){
            return"livraria/formulario_pedido";
        }

        Pedido pedido = requisicao.toPedido();
        pedidoRepository.save(pedido);

        List<Livraria> livrarias = livrariaRepository.findAll();
        List<String> nomeDasLivrarias = new ArrayList<String>(); 
        for(Livraria livraria:livrarias){
            nomeDasLivrarias.add(livraria.getNome());
        }

        model.addAttribute("nomeDasLivrarias",nomeDasLivrarias);
        
        return "redirect:/livraria";
    }
}
