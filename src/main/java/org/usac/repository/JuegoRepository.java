/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.usac.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.usac.dto.FileDto;
import org.usac.model.Videojuego;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ebany
 */
@RequestScoped
@Transactional
public class JuegoRepository implements PanacheRepository<Videojuego> {

    GeneroRepository generoRepository;
    PlataformaRepository plataformaRepository;
    LanguageRepository languageRepository;

    public JuegoRepository(GeneroRepository generoRepository, PlataformaRepository plataformaRepository, LanguageRepository languageRepository) {
        this.generoRepository = generoRepository;
        this.plataformaRepository = plataformaRepository;
        this.languageRepository = languageRepository;
    }

    public void generateJsonFile() {
        Map<String, Object> params = new HashMap<>();
        String query = "SELECT vj FROM Videojuego vj";
        PanacheQuery panacheQuery = find(query, params);

        List<Videojuego> result;
        if (true) {
            result = panacheQuery.page(2, 100000).list();
        } else {
            result = panacheQuery.list();
        }

        List<FileDto> fileDtoList = new ArrayList<>();

        for (Videojuego vj : result) {
            FileDto fileDto = new FileDto(vj.getNombre(), vj.getAcercaDe(), vj.getStoryline(), vj.getFechaLanzamiento(), vj.getRaiting(), vj.getRaitingCount());

            if(!vj.getLanguageSupports().isEmpty()) {
                List<String> values = new ArrayList<>();
                for (int i = 0; i < vj.getLanguageSupports().size(); i++) {
                    var item = this.languageRepository.findById(vj.getLanguageSupports().get(i).getLanguage());
                    if(item != null)
                        values.add(item.getName());
                }
                fileDto.setLanguage_support(values);
            }

            if(!vj.getPlataformaVideojuego().isEmpty()) {
                List<String> values = new ArrayList<>();
                for (int i = 0; i < vj.getPlataformaVideojuego().size(); i++) {
                    var item = this.plataformaRepository.findById(vj.getPlataformaVideojuego().get(i).getIdPlataforma());
                    if(item != null)
                        values.add(item.getNombre());
                }
                fileDto.setPlataforma(values);
            }

            if(!vj.getVideojuegoGenero().isEmpty()) {
                List<String> values = new ArrayList<>();
                for (int i = 0; i < vj.getVideojuegoGenero().size(); i++) {
                    var item = this.generoRepository.findById(vj.getVideojuegoGenero().get(i).getIdGenero());
                    if(item != null)
                        values.add(item.getNombre());
                }
                fileDto.setGenero(values);
            }

            System.out.println(vj.getVideojuegoGenero().size());

            fileDtoList.add(fileDto);
        }

        System.out.println("---------------------------------");
        System.out.println(fileDtoList.size());
        System.out.println("---------------------------------");
        //create json file
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new java.io.File("src/main/resources/data2.json"), fileDtoList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
