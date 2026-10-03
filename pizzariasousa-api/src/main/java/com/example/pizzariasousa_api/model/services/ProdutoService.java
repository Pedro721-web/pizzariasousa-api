package com.example.pizzariasousa_api.model.services;

import com.example.pizzariasousa_api.model.entity.Produto;
import com.example.pizzariasousa_api.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired  //Injeção de dependência automática 
    private ProdutoRepository produtoRepository;

    // Método responsável em listar todos os produtos cadastrados no banco de dados

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    // Método responsável em Criar o Produto no banco de dados

    public Produto save(Produto produto) {
        produto.setCodStatus(true);
        return produtoRepository.save(produto);
    }



    
    // Método responsável em listar o produto por ID

    public Produto findById(Long id) {
        return produtoRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Produto não encontrado com o id " + id));
    }

    // Método responsavel em atualizar o produto 

    public Produto uptade(Long id, Produto produto) {
        Produto produtoExistente = findById(id);
        produtoExistente.setNome(produto.getNome());
        produtoExistente.setDescricao(produto.getDescricao());
        produtoExistente.setTipo(produto.getTipo());
        produtoExistente.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        produtoExistente.setValorCompra(produto.getValorCompra());
        produtoExistente.setValorVenda(produto.getValorVenda());
        produtoExistente.setCodStatus(produto.isCodStatus());
        return produtoRepository.save(produtoExistente);
    }

    // Método responsável em excluir o produto ( exclusão física )

    public void delete(Long id) {
        Produto produtoExistente = findById(id);
        produtoRepository.delete(produtoExistente);
    }

}