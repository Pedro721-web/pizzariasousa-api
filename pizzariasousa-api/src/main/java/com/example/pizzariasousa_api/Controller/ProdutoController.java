package com.example.pizzariasousa_api.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pizzariasousa_api.model.entity.Produto;

@RestController 
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

 List<Produto> produtos = new ArrayList<Produto>();

@GetMapping 
public List<Produto> findAll() {
    Produto p1 = new Produto();
    p1.setId(1L);
    p1.setNome("Pizza Meio a Meio");
    p1.setDescricao("Pizza metade calabresa e metade queijo");
    p1.setTipo("Pizza salgada");
    p1.setValorCompra(45);
    p1.setValorVenda(55);
    p1.setQuantidadeEstoque(30);
    p1.setCodStatus(true);

    Produto p2 = new Produto();
    p2.setId(2L);
    p2.setNome("Pizza de Chocolate Branco");
    p2.setDescricao("Pizza com bastante Chocolate Branco");
    p2.setTipo("Pizza doce");
    p2.setValorCompra(45);
    p2.setValorVenda(55);
    p2.setQuantidadeEstoque(20);
    p2.setCodStatus(true);

    produtos.add(p1);
    produtos.add(p2);
    
    return produtos;
    }
}
