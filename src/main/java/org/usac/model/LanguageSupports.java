package org.usac.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;

/**
 *
 * @author ebany
 */
@Entity
@Table(name = "Language_supports")
public class LanguageSupports implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game")
    @JsonBackReference(value = "languageSupports")
    private Videojuego game;

    @Id
    @Column(name = "language")
    private Long language;

    public Videojuego getGame() {
        return game;
    }

    public void setGame(Videojuego game) {
        this.game = game;
    }

    public Long getLanguage() {
        return language;
    }

    public void setLanguage(Long language) {
        this.language = language;
    }
}
