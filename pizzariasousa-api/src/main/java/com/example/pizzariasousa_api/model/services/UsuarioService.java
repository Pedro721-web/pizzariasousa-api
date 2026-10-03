package com.example.pizzariasousa_api.model.services;

import com.example.pizzariasousa_api.model.entity.Usuario;
import com.example.pizzariasousa_api.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class UsuarioService {

    @Autowired 
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario) {
        usuario.setCodStatus(true);
        return usuarioRepository.save(usuario);
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Usuario não encontrado com o id " + id));
    }

    public Usuario uptade(Long id, Usuario usuario) {
        Usuario usuarioExistente = findById(id);
        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setCpf(usuario.getCpf());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setSenha(usuario.getSenha());
        usuarioExistente.setSexo(usuario.getSexo());
        usuarioExistente.setLogradouro(usuario.getLogradouro());
        usuarioExistente.setCep(usuario.getCep());
        usuarioExistente.setBairro(usuario.getBairro());
        usuarioExistente.setCidade(usuario.getCidade());
        usuarioExistente.setCodStatus(usuario.isCodStatus());
        usuarioExistente.setUf(usuario.getUf());
        return usuarioRepository.save(usuarioExistente);
    }
    
}
