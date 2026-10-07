package com.example.pizzariasousa_api.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pizzariasousa_api.model.entity.Categoria;
import com.example.pizzariasousa_api.model.services.CategoriaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/api/v1/Categoria")
public class CategoriaController {

    @Autowired 
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodos() {
        return ResponseEntity.ok(categoriaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {

        Categoria novoCategoria = categoriaService.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCategoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(categoriaService.findById(Long.parseLong(id)));
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
    public ResponseEntity<Object> atualizarCategoria(@PathVariable String id, @RequestBody Categoria categoria) {
        try {
            return ResponseEntity.ok(categoriaService.uptade(Long.parseLong(id), categoria));
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
                    "message", "Categoria não encontrado com o id: " + id

                ) 
            );
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Object> excluirCategoria(@PathVariable String id) {
        try {
            categoriaService.delete(Long.parseLong(id));
            return ResponseEntity.ok().body(
            Map.of(
                    "status", 200,
                    "message",
                    "Categoria excluido com sucesso!"
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
                    "message", "Categoria não encontrada com o id " + id
                    
                )
            );
        }
    }

}
