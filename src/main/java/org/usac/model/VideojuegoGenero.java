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
@Table(name = "videojuego_genero")
public class VideojuegoGenero implements Serializable {

    @Id
    @Column(name = "Genero_idGenero")
    private Long idGenero;

    @Id
    @Column(name = "Videojuego_idVideojuego")
    private Long idVideojuego;

    public VideojuegoGenero() {
    }

    public VideojuegoGenero(Long idGenero, Long idVideojuego) {
        this.idGenero = idGenero;
        this.idVideojuego = idVideojuego;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public Long getIdVideojuego() {
        return idVideojuego;
    }

    public void setIdVideojuego(Long idVideojuego) {
        this.idVideojuego = idVideojuego;
    }

}
