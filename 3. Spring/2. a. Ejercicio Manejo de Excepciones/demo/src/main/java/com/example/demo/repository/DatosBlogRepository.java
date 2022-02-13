package com.example.demo.repository;

import com.example.demo.model.datosBlog;

import java.util.List;

public interface datosBlogRepository {

    public datosBlog nuevoBlog(datosBlog entrada);

    public datosBlog findById(Long id);

    public List<datosBlog> getBlogs();
}
