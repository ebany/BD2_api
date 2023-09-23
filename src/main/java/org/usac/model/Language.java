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
@Table(name = "Language")
public class Language implements Serializable {

    @Id
    @Column(name = "idLanguage")
    private Long idLanguage;

    @Column(name = "name")
    private String name;

    public Language() {
    }

    public Language(Long idLanguage, String name) {
        this.idLanguage = idLanguage;
        this.name = name;
    }

    public Long getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(Long idLanguage) {
        this.idLanguage = idLanguage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
