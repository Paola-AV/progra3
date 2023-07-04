package com.api.crudAPI.models;


import javax.persistence.*;
@Entity
@Table(name = "usuario")

public class UsuarioModel {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long IDusuario;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String contraseña;
    @Column
    private String tipo;


    public Long getIDusuario() {
        return this.IDusuario;
    }

    public void setIDusuario(Long IDusuario) {
        this.IDusuario = IDusuario;
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

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
