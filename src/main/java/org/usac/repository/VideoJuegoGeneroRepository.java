/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.usac.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import org.usac.model.VideojuegoGenero;

/**
 *
 * @author ebany
 */
@RequestScoped
@Transactional
public class VideoJuegoGeneroRepository implements PanacheRepository<VideojuegoGenero> {
    
}
