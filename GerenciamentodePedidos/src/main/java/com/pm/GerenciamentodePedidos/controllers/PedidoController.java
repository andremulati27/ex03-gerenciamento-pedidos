package com.pm.GerenciamentodePedidos.controllers;

import com.pm.GerenciamentodePedidos.models.PedidosModel;
import com.pm.GerenciamentodePedidos.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidosModel>> findAll(){
        List<PedidosModel> model= pedidoService.findAll();

        return ResponseEntity.status(200).body(model);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PedidosModel>> buscarId(@PathVariable Long id){
        Optional<PedidosModel> model = pedidoService.buscarId(id);

        return ResponseEntity.status(200).body(model);
    }

    @PostMapping
    public ResponseEntity<PedidosModel> criarPedido(@RequestBody PedidosModel pedidoCriado){
        PedidosModel pedido = pedidoService.criarPedido(pedidoCriado);

        return ResponseEntity.status(201).body(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidosModel> atualizarPedido(@RequestBody PedidosModel pedidoNovo,@PathVariable Long id){

        PedidosModel pedidoAntigo = pedidoService.atualizarStatusPedido(pedidoNovo,id);
        return ResponseEntity.status(200).body(pedidoAntigo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id){
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }

}
