package com.lucasleao.pedidoservice.repository;

import com.lucasleao.pedidoservice.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Aqui você pode adicionar métodos personalizados, se quiser, como:
    // List<Pedido> findByDescricao(String descricao);
}
