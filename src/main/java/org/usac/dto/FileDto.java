package org.usac.dto;

import java.util.ArrayList;
import java.util.List;

public class FileDto {

    private String nombre;
    private String acerca_de;
    private String storyline;
    private String fecha_lanzamiento;
    private Double rating;
    private Long ratingCount;
    private List<String> genero;
    private List<String> plataforma;
    private List<String> language_support;

    public FileDto(String nombre, String acerca_de, String storyline, String fecha_lanzamiento, Double rating, Long ratingCount) {
        this.nombre = nombre;
        this.acerca_de = acerca_de;
        this.storyline = storyline;
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.rating = rating;
        this.ratingCount = ratingCount;
        this.genero = new ArrayList<>();
        this.plataforma = new ArrayList<>();
        this.language_support = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAcerca_de() {
        return acerca_de;
    }

    public void setAcerca_de(String acerca_de) {
        this.acerca_de = acerca_de;
    }

    public String getStoryline() {
        return storyline;
    }

    public void setStoryline(String storyline) {
        this.storyline = storyline;
    }

    public String getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    public void setFecha_lanzamiento(String fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Long getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Long ratingCount) {
        this.ratingCount = ratingCount;
    }

    public List<String> getGenero() {
        return genero;
    }

    public void setGenero(List<String> genero) {
        this.genero = genero;
    }

    public List<String> getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(List<String> plataforma) {
        this.plataforma = plataforma;
    }

    public List<String> getLanguage_support() {
        return language_support;
    }

    public void setLanguage_support(List<String> language_support) {
        this.language_support = language_support;
    }
}
