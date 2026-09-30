package com.example.pizzariasousa_api.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pizzariasousa_api.model.entity.Categoria;

@RestController 
@RequestMapping ("/api/v1/Categoria")
public class CategoriaController {

    List<Categoria> categorias = new ArrayList<Categoria>();

@GetMapping 
public List<Categoria> findAll() {
    Categoria c1 = new Categoria();
    c1.setId(1L);
    c1.setNome("Pizza");
    c1.setDescricao("Pizzas salgadas e doces");
    c1.setCodStatus(true);

    Categoria c2 = new Categoria();
    c2.setId(2L);
    c2.setNome("Bebidas");
    c2.setDescricao("Bebidas diversas");
    c2.setCodStatus(true);

    categorias.add(c1);
    categorias.add(c2);
    
    return categorias;

}
}
