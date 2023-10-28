package org.usac.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Videojuego_idVideojuego")
    @JsonBackReference(value = "videojuegoGenero")
    private Videojuego idVideojuego;

    public VideojuegoGenero() {
    }

    public VideojuegoGenero(Long idGenero, Long idVideojuego) {
        //this.idGenero = idGenero;
        //this.idVideojuego = idVideojuego;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public Videojuego getIdVideojuego() {
        return idVideojuego;
    }

    public void setIdVideojuego(Videojuego idVideojuego) {
        this.idVideojuego = idVideojuego;
    }
}
