package com.example.pizzariasousa_api.model.repository;

import com.example.pizzariasousa_api.model.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long>{

}
