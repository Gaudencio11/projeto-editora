package com.marcos.projetos.editora.repository;

import com.marcos.projetos.editora.model.Livraria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrariaRepository extends JpaRepository<Livraria, Long> {

    //Aqui vou colocar algumas depois como find by nome_livravira
    //List<Pedido> findByStatuspedido(StatusPedido statuspedido);
}
