package com.marcos.projetos.editora.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("livraria")
public class LivrariaController {

    @GetMapping
    public String homeLivrariaView(){
        
        
        return"livraria/home";

    }

    
}
