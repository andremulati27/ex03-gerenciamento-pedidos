package com.pm.GerenciamentodePedidos.services;

import com.pm.GerenciamentodePedidos.models.PedidosModel;
import com.pm.GerenciamentodePedidos.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidosModel> findAll(){
        return pedidoRepository.findAll();
    }

    public Optional<PedidosModel> buscarId(Long id){
        return pedidoRepository.findById(id);
    }

    public PedidosModel criarPedido(PedidosModel model){
        return pedidoRepository.save(model);
    }

    public void deletarPedido(Long id){
        pedidoRepository.deleteById(id);
    }

    public PedidosModel atualizarStatusPedido(PedidosModel model, Long id){
        PedidosModel atual = pedidoRepository.findById(id).get();

        atual.setStatus(model.getStatus());

        return pedidoRepository.save(atual);
    }
}
