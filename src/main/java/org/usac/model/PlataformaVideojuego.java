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
@Table(name = "plataforma_videojuego")
public class PlataformaVideojuego implements Serializable {

    @Id
    @Column(name = "Videojuego_idVideojuego")
    private Long idVideojuego;

    @Id
    @Column(name = "Plataforma_idPlataforma")
    private Long idPlataforma;

    public PlataformaVideojuego() {
    }

    public PlataformaVideojuego(Long idVideojuego, Long idPlataforma) {
        this.idVideojuego = idVideojuego;
        this.idPlataforma = idPlataforma;
    }

    public Long getIdVideojuego() {
        return idVideojuego;
    }

    public void setIdVideojuego(Long idVideojuego) {
        this.idVideojuego = idVideojuego;
    }

    public Long getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(Long idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

}
