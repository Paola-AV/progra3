/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.crudAPI.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
@Entity
@Table(name = "cliente")

public class ClienteModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long IDcliente;
    
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String telefono;
    @Column
    private String gmail;
    @Column
    private int IDfiador;

    public Long getIDcliente() {
        return IDcliente;
    }

    public void setIDcliente(Long IDcliente) {
        this.IDcliente = IDcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public int getIDfiador() {
        return IDfiador;
    }

    public void setIDfiador(int IDfiador) {
        this.IDfiador = IDfiador;
    }
    
    
}
