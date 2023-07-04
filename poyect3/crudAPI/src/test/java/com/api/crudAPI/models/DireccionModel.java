package com.api.crudAPI.models;
import javax.persistence.*;

@Entity
@Table(name = "direccion")

public class DireccionModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long IDdireccion;
    
    @Column
    private String provincia;
    @Column
    private String distrito;
    @Column
    private String canton;
    @Column
    private String señales;


    public Long getIDdireccion() {
        return this.IDdireccion;
    }

    public void setIDdireccion(Long IDdireccion) {
        this.IDdireccion = IDdireccion;
    }

    public String getProvincia() {
        return this.provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return this.distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCanton() {
        return this.canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getSeñales() {
        return this.señales;
    }

    public void setSeñales(String señales) {
        this.señales = señales;
    }

}
