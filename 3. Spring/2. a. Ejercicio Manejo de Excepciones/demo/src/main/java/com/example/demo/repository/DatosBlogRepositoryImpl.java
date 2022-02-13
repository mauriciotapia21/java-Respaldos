package com.example.demo.repository;

import com.example.demo.model.datosBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class datosBlogRepositoryImpl implements datosBlogRepository {

    private Map<Long, datosBlog> map = new HashMap<>();


    public datosBlog nuevoBlog(datosBlog entrada) {
        Long newId = entrada.getId();
        this.map.put(newId, entrada);
        return entrada;
    }

    public datosBlog findById(Long id) {
        return this.map.get(id);
    }

    public List<datosBlog> getBlogs() {
        return this.map.entrySet().stream().map(e -> {
            e.getValue().setId(e.getKey());
            return e.getValue();
        }).collect(Collectors.toList());
    }

}
