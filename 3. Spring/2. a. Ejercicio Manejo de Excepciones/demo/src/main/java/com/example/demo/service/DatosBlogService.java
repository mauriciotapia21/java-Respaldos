package com.example.demo.service;

import com.example.demo.dto.datosBlogDTO;

import java.util.List;

public interface datosBlogService {

    public datosBlogDTO crearNuevoBLog(datosBlogDTO entradaBlogDTO);

    public datosBlogDTO getBlog(Long id);

    public List<datosBlogDTO> getBlogs();
}
