package com.example.pizzariasousa_api.Controller;

import com.example.pizzariasousa_api.model.entity.Categoria;
import com.example.pizzariasousa_api.model.entity.Pedido;
import com.example.pizzariasousa_api.model.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


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

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(pedidoService.findById(Long.parseLong(id)));
        } catch (NumberFormatException e ) {
            return ResponseEntity.badRequest().body (
            Map.of(
                    "status", 400,
                    "error", "Bad Request",
                    "message", "O id informado não é válido: " + id
                  )
            );    
        } catch (RuntimeException e ) {
            return ResponseEntity.status(404).body (
            Map.of(
                    "status", 404,
                    "error", "Not Found",
                    "message", "Pedido não encontrada com o id: " + id
                )
            );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarPedido(@PathVariable String id, @RequestBody Pedido pedido) {
        try {
            return ResponseEntity.ok(pedidoService.uptade(Long.parseLong(id), pedido));
        } catch (NumberFormatException e ) {
            return ResponseEntity.badRequest().body (
            Map.of(
                    "status", 400,
                    "error", "Bad Request",
                    "message", "O id informado não é válido: " + id
                )
            );
        } catch (RuntimeException e ) {
            return ResponseEntity.status(404).body (
            Map.of(
                    "status", 404,
                    "error", "Not Found",
                    "message", "Pedido não encontrado com o id: " + id

                ) 
            );
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Object> excluirPedido(@PathVariable String id) {
        try {
            pedidoService.delete(Long.parseLong(id));
            return ResponseEntity.ok().body(
            Map.of(
                    "status", 200,
                    "message",
                    "Pedido excluido com sucesso!"
                )
            );
        } catch (NumberFormatException e ) {
            return ResponseEntity.badRequest().body(
            Map.of(
                    "status", 400, 
                    "error", "Bad Request",
                    "message", "O id informado não é válido: " + id
                )
            );
        } catch (RuntimeException e ) {
            return ResponseEntity.status(404).body(
            Map.of(    
                    "status", 404,
                    "error", "Not Found",
                    "message", "Pedido não encontrada com o id " + id
                    
                )
            );
        }
    }
}
