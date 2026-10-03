package com.example.pizzariasousa_api.model.services;

import com.example.pizzariasousa_api.model.entity.ItemPedido;
import com.example.pizzariasousa_api.model.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class ItemPedidoService {

    @Autowired 
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> findAll() {
        return itemPedidoRepository.findAll();
    }

    public ItemPedido save(ItemPedido itemPedido) {
        itemPedido.setCodStatus(true);
        return itemPedidoRepository.save(itemPedido);
    }

    public ItemPedido findById(Long id) {
        return itemPedidoRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("ItemPedido não encontrado com o id " + id));
    }
    
    public ItemPedido uptade(Long id, ItemPedido itemPedido) {
        ItemPedido itemPedidoExistente = findById(id);
        itemPedidoExistente.setQuantidadeItem(itemPedido.getQuantidadeItem());
        itemPedidoExistente.setValorUnitario(itemPedido.getValorUnitario());
        itemPedidoExistente.setCodStatus(itemPedido.isCodStatus());
        return itemPedidoRepository.save(itemPedidoExistente);
    }

     public void delete(Long id) {
        ItemPedido itemPedidoExistente = findById(id);
        itemPedidoRepository.delete(itemPedidoExistente);
    }


}
