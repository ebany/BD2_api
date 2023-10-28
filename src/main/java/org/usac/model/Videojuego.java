package org.usac.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ebany
 */
@Entity
@Table(name = "Videojuego")
public class Videojuego implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idVideojuego")
    private Long idVideojuego;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Acerca_de")
    private String acercaDe;

    @Column(name = "storyline")
    private String storyline;

    @Column(name = "Fecha_Lanzamiento")
    private String fechaLanzamiento;

    @Column(name = "raiting")
    private Double raiting;

    @Column(name = "raitingCount")
    private Long raitingCount;

    @Column(name = "aggregatedRaiting")
    private Double aggregatedRaiting;

    @Column(name = "aggregatedRaitingCount")
    private Long aggregatedRaitingCount;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "game", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference(value = "languageSupports")
    private List<LanguageSupports> languageSupports;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "idVideojuego", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference(value = "plataformaVideojuego")
    private List<PlataformaVideojuego> plataformaVideojuego;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "idVideojuego", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference(value = "videojuegoGenero")
    private List<VideojuegoGenero> videojuegoGenero;

    public Videojuego() {
    }

    public Videojuego(Long idVideojuego, String nombre, String acercaDe, String storyline, String fechaLanzamiento, Double raiting, Long raitingCount, Double aggregatedRaiting, Long aggregatedRaitingCount) {
        this.idVideojuego = idVideojuego;
        this.nombre = nombre;
        if (acercaDe.length() > 1000) {
            this.acercaDe = acercaDe.substring(0, 900);
        } else {
            this.acercaDe = acercaDe;
        }
        if (storyline.length() > 1000) {
            this.storyline = storyline.substring(0, 900);
        } else {
            this.storyline = storyline;
        }
        this.fechaLanzamiento = fechaLanzamiento;
        this.raiting = raiting;
        this.raitingCount = raitingCount;
        this.aggregatedRaiting = aggregatedRaiting;
        this.aggregatedRaitingCount = aggregatedRaitingCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdVideojuego() {
        return idVideojuego;
    }

    public void setIdVideojuego(Long idVideojuego) {
        this.idVideojuego = idVideojuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAcercaDe() {
        return acercaDe;
    }

    public void setAcercaDe(String acercaDe) {
        this.acercaDe = acercaDe;
    }

    public String getStoryline() {
        return storyline;
    }

    public void setStoryline(String storyline) {
        this.storyline = storyline;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Double getRaiting() {
        return raiting;
    }

    public void setRaiting(Double raiting) {
        this.raiting = raiting;
    }

    public Long getRaitingCount() {
        return raitingCount;
    }

    public void setRaitingCount(Long raitingCount) {
        this.raitingCount = raitingCount;
    }

    public Double getAggregatedRaiting() {
        return aggregatedRaiting;
    }

    public void setAggregatedRaiting(Double aggregatedRaiting) {
        this.aggregatedRaiting = aggregatedRaiting;
    }

    public Long getAggregatedRaitingCount() {
        return aggregatedRaitingCount;
    }

    public void setAggregatedRaitingCount(Long aggregatedRaitingCount) {
        this.aggregatedRaitingCount = aggregatedRaitingCount;
    }

    public List<LanguageSupports> getLanguageSupports() {
        return languageSupports;
    }

    public void setLanguageSupports(List<LanguageSupports> languageSupports) {
        this.languageSupports = languageSupports;
    }

    public List<PlataformaVideojuego> getPlataformaVideojuego() {
        return plataformaVideojuego;
    }

    public void setPlataformaVideojuego(List<PlataformaVideojuego> plataformaVideojuego) {
        this.plataformaVideojuego = plataformaVideojuego;
    }

    public List<VideojuegoGenero> getVideojuegoGenero() {
        return videojuegoGenero;
    }

    public void setVideojuegoGenero(List<VideojuegoGenero> videojuegoGenero) {
        this.videojuegoGenero = videojuegoGenero;
    }
}
