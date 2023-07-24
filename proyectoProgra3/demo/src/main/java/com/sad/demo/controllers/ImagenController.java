package com.sad.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sad.demo.models.ImagenModel;
import com.sad.demo.services.ImagenService;


//en esta clase se reciben las peticiones en web
@RestController // da a entender que la clase tiene funcion controller
@RequestMapping("/imagen") // da el path para hacer las peticiones a la tabla elegida
public class ImagenController {
    @Autowired
    private ImagenService imagenService;// se declara Imagen Service como variable

    // para obtener los datos de imagenes
    @GetMapping
    public ArrayList<ImagenModel> getImagen() {
        return this.imagenService.getImagen();
    }

    // Guarda datos al hacer un post
    @PostMapping
    public ImagenModel saveImagen(@RequestBody ImagenModel imagen) {
        return this.imagenService.saveImagen(imagen);
    }

    // para obtener los datos de imagenes segun un ID especifico
    @GetMapping(path = "/{IDimagen}")
    public Optional<ImagenModel> getImagenbyId(@PathVariable Long IDimagen) {
        return this.imagenService.getbyId(IDimagen);
    }

    // obtiene solucitudes PUT, desde web/imagen
    @PutMapping(path = "/{IDimagen}")
    public ImagenModel updateById(@RequestBody ImagenModel request, @PathVariable("IDimagen") Long IDimagen) {
        return this.imagenService.updateById(request, IDimagen);
    }

    // elimina datos por ID
    @DeleteMapping(path = "/{IDimagen}")
    public String deleteById(@PathVariable("IDimagen") Long IDimagen) {
        boolean ok = this.imagenService.deleteImagen(IDimagen);
        if (ok) {
            return "La imagen con el ID " + IDimagen + " ha sido eliminado";
        } else {
            return "Hubo un problema y la imagen con el ID " + IDimagen + " no ha podido ser eliminado";
        }
    }
}
