package org.usac.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author ebany
 */
@Entity
@Table(name = "Plataforma")
public class Plataforma implements Serializable {

    @Id
    @Column(name = "idPlataforma")
    private Long idPlataforma;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    public Plataforma() {
    }

    public Plataforma(Long idPlataforma, String nombre, String descripcion) {
        this.idPlataforma = idPlataforma;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(Long idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
