package com.example.pizzariasousa_api.Controller;

import com.example.pizzariasousa_api.model.entity.Produto;
import com.example.pizzariasousa_api.model.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;



    /* @RequestBody : Corpo da Reqquisição ( Recebendo um objeto JSON )
    ResponseEntity: Toda resposta HTTP (status, cabeçalhos e corpo), aqui temos mais controle sobre o que é devolvido para o client
     1. Status HTTP: (200 ok, 201 CREATED, 404 NOT FOUND etc...)
     2. Headers: ( cabeçalhos extras, como Location, Authorization etc...)
     3. Body: ( o objeto que será convertido em JSON/XML para o client ) 
    */
    
    @RestController 
    @RequestMapping("/api/v1/produtos")
    public class ProdutoController {
    
        @Autowired 
        private ProdutoService produtoService;
    
        @GetMapping 
        public ResponseEntity<List<Produto>> listarTodos() {
    
            return ResponseEntity.ok(produtoService.findAll());
        }

    @PostMapping 
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
        
        Produto novo = produtoService.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }
    
   

}
