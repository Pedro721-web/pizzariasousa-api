package com.example.pizzariasousa_api.Controller;

import com.example.pizzariasousa_api.model.entity.Pedido;
import com.example.pizzariasousa_api.model.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


 @RestController 
@RequestMapping("/api/v1/pedido")
public class PedidoController {

      @Autowired 
        private PedidoService pedidoService;
    
        @GetMapping 
        public ResponseEntity<List<Pedido>> listarTodos() {
    
            return ResponseEntity.ok(pedidoService.findAll());
        }

    @PostMapping 
    public ResponseEntity<Pedido> salvarPedido(@RequestBody Pedido pedido) {
        
        Pedido novo = pedidoService.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

}
