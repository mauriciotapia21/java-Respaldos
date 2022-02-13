package com.example.demo.service;
import com.example.demo.dto.datosBlogDTO;
import com.example.demo.exception.DuplicatedEntryBlogException;
import com.example.demo.exceptions.NotFoundEntradaBlogException;
import com.example.demo.model.datosBlog;
import com.example.demo.repository.datosBlogRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class datosBlogServiceImpl implements datosBlogService {

    @Autowired
    private datosBlogRepositoryImpl entradaBlogRepository;

    public datosBlogDTO crearNuevoBLog(datosBlogDTO entradaBlogDTO) {
        datosBlog entradaBlog1 = entradaBlogRepository.findById(entradaBlogDTO.getId());
        if (!Objects.isNull(entradaBlog1)) {
            throw new DuplicatedEntryBlogException();
        }
        datosBlog entradaBlog = entradaBlogRepository.nuevoBlog(entradaBlogDTOToEntradaBlog(entradaBlogDTO));
        return entradaBlogToEntradaBlogDTO(entradaBlog);

    }

    public datosBlogDTO getBlog(Long id) {
        datosBlog entradaBlog = entradaBlogRepository.findById(id);
        if (Objects.isNull(entradaBlog)) {
            throw new NotFoundEntradaBlogException();
        }
        return entradaBlogToEntradaBlogDTO(entradaBlog);
    }

    public List<datosBlogDTO> getBlogs() {
        return entradaBlogRepository.getBlogs().stream().map(e -> entradaBlogToEntradaBlogDTO(e)).collect(Collectors.toList());
    }
    public datosBlog entradaBlogDTOToEntradaBlog(datosBlogDTO entradaBlogDTO){
        datosBlog entradaBlog = new datosBlog();
        entradaBlog.setId(entradaBlogDTO.getId());
        entradaBlog.setAutor(entradaBlogDTO.getAutor());
        entradaBlog.setFecha(entradaBlogDTO.getFecha());
        entradaBlog.setTitulo(entradaBlogDTO.getTitulo());
        return entradaBlog;
    }
    public datosBlogDTO entradaBlogToEntradaBlogDTO(datosBlog entradaBlog){
        datosBlogDTO entradaBlogDTO = new datosBlogDTO();
        entradaBlogDTO.setId(entradaBlog.getId());
        entradaBlogDTO.setAutor(entradaBlog.getAutor());
        entradaBlogDTO.setFecha(entradaBlog.getFecha());
        entradaBlogDTO.setTitulo(entradaBlog.getTitulo());
        return entradaBlogDTO;
    }


}

