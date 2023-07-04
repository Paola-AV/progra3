package com.sad.demo.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="contrato")
public class ContratoModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long IDcontrato;
    
    @Column
    private String fechaPago;
    @Column
    private String IDcliente;
    @Column
    private String IDpropiedad;


    public Long getIDcontrato() {
        return this.IDcontrato;
    }

    public void setIDcontrato(Long IDcontrato) {
        this.IDcontrato = IDcontrato;
    }

    public String getFechaPago() {
        return this.fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getIDcliente() {
        return this.IDcliente;
    }

    public void setIDcliente(String IDcliente) {
        this.IDcliente = IDcliente;
    }

    public String getIDpropiedad() {
        return this.IDpropiedad;
    }

    public void setIDpropiedad(String IDpropiedad) {
        this.IDpropiedad = IDpropiedad;
    }
   
}
