package com.sad.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sad.demo.Repository.IImagenRepository;
import com.sad.demo.models.ImagenModel;


@Service // denota clase de tipo servicio conecta repositorios
public class ImagenService {
    @Autowired // spring instancia lo siguiente de manera automatica
    IImagenRepository imagenRepository; // se declara una variable de repositorio

    // regresa los objetos dentro de ImagenModel, las columnas de la tabla imagen
    public ArrayList<ImagenModel> getImagen() {
        return (ArrayList<ImagenModel>) imagenRepository.findAll();// findAll muestra todos los registros
    }

    // guarda la informacion que se agregue en post
    public ImagenModel saveImagen(ImagenModel imagen) {
        return imagenRepository.save(imagen);
    }

    // busca por ID
    public Optional<ImagenModel> getbyId(Long IDimagen) {
        return imagenRepository.findById(IDimagen);
    }

    // para actualizar o modificar informacion en la tabla
    public ImagenModel updateById(ImagenModel request, Long IDimagen) {
        ImagenModel imagen = imagenRepository.findById(IDimagen).get();
        imagen.setImagen(request.getImagen());
        imagen.setIDpropiedad(request.getIDpropiedad());

        return imagen;
    }

    // para eliminar informacion de la tabla
    public Boolean deleteImagen(Long IDimagen) {
        try {
            imagenRepository.deleteById(IDimagen);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
