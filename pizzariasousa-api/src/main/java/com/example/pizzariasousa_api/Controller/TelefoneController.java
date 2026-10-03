package com.example.pizzariasousa_api.Controller;

import com.example.pizzariasousa_api.model.entity.Telefone;
import com.example.pizzariasousa_api.model.services.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/api/v1/telefone")
public class TelefoneController {

     @Autowired 
        private TelefoneService telefoneService;
    
        @GetMapping 
        public ResponseEntity<List<Telefone>> listarTodos() {
    
            return ResponseEntity.ok(telefoneService.findAll());
        }

    @PostMapping 
    public ResponseEntity<Telefone> salvarTelefone(@RequestBody Telefone telefone) {
        
        Telefone novo = telefoneService.save(telefone);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }
}
