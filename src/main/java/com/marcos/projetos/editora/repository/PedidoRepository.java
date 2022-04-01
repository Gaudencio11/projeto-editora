package com.marcos.projetos.editora.repository;

import com.marcos.projetos.editora.model.Pedido;
import com.marcos.projetos.editora.model.StatusPedido;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    //Aqui vou colocar algumas depois como find by livravira
    //List<Pedido> findByStatuspedido(StatusPedido statuspedido);

    List<Pedido> findByStatus(StatusPedido statuspedido);
}
