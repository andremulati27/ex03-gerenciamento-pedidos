package com.pm.GerenciamentodePedidos.repositories;

import com.pm.GerenciamentodePedidos.models.PedidosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidosModel, Long> {
}
