package com.example.pizzariasousa_api.Controller;

import com.example.pizzariasousa_api.model.entity.Usuario;
import com.example.pizzariasousa_api.model.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

     @Autowired 
        private UsuarioService usuarioService;
    
        @GetMapping 
        public ResponseEntity<List<Usuario>> listarTodos() {
    
            return ResponseEntity.ok(usuarioService.findAll());
        }

    @PostMapping 
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
        
        Usuario novo = usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }
}
