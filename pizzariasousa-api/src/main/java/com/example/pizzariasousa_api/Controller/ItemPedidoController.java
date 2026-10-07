package com.example.pizzariasousa_api.Controller;

import com.example.pizzariasousa_api.model.entity.ItemPedido;
import com.example.pizzariasousa_api.model.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<ItemPedido> save(@RequestBody ItemPedido itemPedido) {
        
        ItemPedido novo = itemPedidoService.save(itemPedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(itemPedidoService.findById(Long.parseLong(id)));
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
                    "message", "Categoria não encontrada com o id: " + id
                )
            );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarItemPedido(@PathVariable String id, @RequestBody ItemPedido itemPedido) {
        try {
            return ResponseEntity.ok(itemPedidoService.uptade(Long.parseLong(id), itemPedido));
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
                    "message", "ItemPedido não encontrado com o id: " + id

                ) 
            );
        }
    }

     @DeleteMapping ("/{id}")
    public ResponseEntity<Object> excluirItemPedido(@PathVariable String id) {
        try {
            itemPedidoService.delete(Long.parseLong(id));
            return ResponseEntity.ok().body(
            Map.of(
                    "status", 200,
                    "message",
                    "ItemPedido excluido com sucesso!"
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
                    "message", "ItemPedido não encontrada com o id " + id
                    
                )
            );
        }
    }

}
