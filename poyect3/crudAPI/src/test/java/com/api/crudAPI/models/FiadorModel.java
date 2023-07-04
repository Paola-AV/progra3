package com.api.crudAPI.models;

import javax.persistence.*;
@Entity
@Table(name = "fiador")

public class FiadorModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long IDfiador;
    
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String telefono;
    @Column
    private String gmail;


    public Long getIDfiador() {
        return this.IDfiador;
    }

    public void setIDfiador(Long IDfiador) {
        this.IDfiador = IDfiador;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGmail() {
        return this.gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

}
