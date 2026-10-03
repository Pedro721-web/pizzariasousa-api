package com.example.pizzariasousa_api.Controller;

import com.example.pizzariasousa_api.model.entity.ItemPedido;
import com.example.pizzariasousa_api.model.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/api/v1/ItemPedido")
public class ItemPedidoController {
  @Autowired 
        private ItemPedidoService itemPedidoService;

        @GetMapping 
        public ResponseEntity<List<ItemPedido>> listarTodos() {
    
            return ResponseEntity.ok(itemPedidoService.findAll());
        }

    @PostMapping 
    public ResponseEntity<ItemPedido> salvarItemPedido(@RequestBody ItemPedido itemPedido) {
        
        ItemPedido novo = itemPedidoService.save(itemPedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

}
