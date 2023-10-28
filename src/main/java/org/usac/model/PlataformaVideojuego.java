package org.usac.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;

/**
 *
 * @author ebany
 */
@Entity
@Table(name = "plataforma_videojuego")
public class PlataformaVideojuego implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Videojuego_idVideojuego")
    @JsonBackReference(value = "plataformaVideojuego")
    private Videojuego idVideojuego;

    @Id
    @Column(name = "Plataforma_idPlataforma")
    private Long idPlataforma;

    public PlataformaVideojuego() {
    }

    public PlataformaVideojuego(Long idVideojuego, Long idPlataforma) {
        //this.idVideojuego = idVideojuego;
        //this.idPlataforma = idPlataforma;
    }

    public Videojuego getIdVideojuego() {
        return idVideojuego;
    }

    public void setIdVideojuego(Videojuego idVideojuego) {
        this.idVideojuego = idVideojuego;
    }

    public Long getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(Long idPlataforma) {
        this.idPlataforma = idPlataforma;
    }
}
