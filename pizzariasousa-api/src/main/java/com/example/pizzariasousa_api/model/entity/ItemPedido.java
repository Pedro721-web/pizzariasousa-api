package com.example.pizzariasousa_api.model.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "ItemPedido")
public class ItemPedido {

    @Id
    @GeneratedValues(strategy = GenerationType.IDENTITY) 
    private Long id;
    @Column(nullable = true)
    private int quantidadeItem;
    @Column(columnDefinition = "DECIMAL(5,2)", nullable = false)
    private boolean codStatus;
    private double valorUnitario;
    
   
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getQuantidadeItem() {
        return quantidadeItem;
    }
    public void setQuantidadeItem(int quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }
    public boolean isCodStatus() {
        return codStatus;
    }
    public void setCodStatus(boolean codStatus) {
        this.codStatus = codStatus;
    }
    public double getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
}
