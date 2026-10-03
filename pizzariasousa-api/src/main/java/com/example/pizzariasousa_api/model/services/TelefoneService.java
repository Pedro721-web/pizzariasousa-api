package com.example.pizzariasousa_api.model.services;

import com.example.pizzariasousa_api.model.entity.Telefone;
import com.example.pizzariasousa_api.model.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class TelefoneService {

     @Autowired  
    private TelefoneRepository telefoneRepository;

    public List<Telefone> findAll() {
        return telefoneRepository.findAll();
    }

    public Telefone save(Telefone telefone) {
        telefone.setCodStatus(true);
        return telefoneRepository.save(telefone);
    }

     public Telefone findById(Long id) {
        return telefoneRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Telefone não encontrado com o id " + id));
    }

    public Telefone uptade(Long id, Telefone telefone) {
        Telefone telefoneExistente = findById(id);
        telefoneExistente.setDdd(telefone.getDdd());
        telefoneExistente.setNumero(telefone.getNumero());
        telefoneExistente.setCodStatus(telefone.isCodStatus());
        return telefoneRepository.save(telefoneExistente);
    }

    public void delete(Long id) {
        Telefone telefoneExistente = findById(id);
        telefoneRepository.delete(telefoneExistente);
    }

}
