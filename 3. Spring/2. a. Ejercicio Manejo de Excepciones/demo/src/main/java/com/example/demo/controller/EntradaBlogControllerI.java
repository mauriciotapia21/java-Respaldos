package com.example.demo.controller;

import com.example.demo.dto.datosBlogDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EntradaBlogControllerI {

    @PostMapping("/blog")
    public datosBlogDTO nuevoBlog(@RequestBody datosBlogDTO entradaBlogDTO);

    @GetMapping("/blog/{id}")
    public datosBlogDTO getBlog(@PathVariable Long id);

    @GetMapping("/blogs")
    public List<datosBlogDTO> getBlogs();
}
