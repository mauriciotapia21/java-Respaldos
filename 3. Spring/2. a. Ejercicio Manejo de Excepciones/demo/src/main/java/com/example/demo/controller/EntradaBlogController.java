package com.example.demo.controller;
import com.example.demo.dto.datosBlogDTO;
import com.example.demo.service.datosBlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntradaBlogController implements EntradaBlogControllerI {
    @Autowired
    private datosBlogServiceImpl service;


    public datosBlogDTO nuevoBlog(@RequestBody datosBlogDTO entradaBlogDTO){
        return service.crearNuevoBLog(entradaBlogDTO);
    }

    public datosBlogDTO getBlog(@PathVariable Long id){
        return service.getBlog(id);
    }

    public List<datosBlogDTO> getBlogs(){
        return service.getBlogs();
    }
}
