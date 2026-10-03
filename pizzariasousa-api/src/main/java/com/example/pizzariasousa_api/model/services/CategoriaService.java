package com.example.pizzariasousa_api.model.services;


import com.example.pizzariasousa_api.model.entity.Categoria;
import com.example.pizzariasousa_api.model.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class CategoriaService {

    @Autowired 
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria save(Categoria categoria) {
        categoria.setCodStatus(true);
        return categoriaRepository.save(categoria);
    }

     public Categoria findById(Long id) {
        return categoriaRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Categoria não encontrado com o id " + id));
    }

     public Categoria uptade(Long id, Categoria categoria) {
        Categoria categoriaExistente = findById(id);
        categoriaExistente.setNome(categoria.getNome());
        categoriaExistente.setDescricao(categoria.getDescricao());
        categoriaExistente.setCodStatus(categoria.isCodStatus());
        return categoriaRepository.save(categoriaExistente);
    }

    public void delete(Long id) {
        Categoria categoriaExistente = findById(id);
        categoriaRepository.delete(categoriaExistente);
    }


}
