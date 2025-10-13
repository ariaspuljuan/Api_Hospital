// ControllerCategorias.java
package com.jdc.hospital_crud.controller;

import com.jdc.hospital_crud.model.Categorias;
import com.jdc.hospital_crud.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class ControllerCategorias {

    @Autowired
    private CategoriasRepository categoriasRepository;

    @GetMapping("/")
    public String holaMundo() {
        return "Hola mundo desde Categorias";
    }

    @GetMapping("/all")
    public List<Categorias> getCategorias() {
        return categoriasRepository.findAll();
    }

    @PostMapping("/save")
    public String saveCategoria(@RequestBody Categorias categoria) {
        categoriasRepository.save(categoria);
        return "Categoría guardada";
    }

    @PutMapping("/update/{id}")
    public String updateCategoria(@PathVariable int id, @RequestBody Categorias categoria) {
        Categorias updateCategoria = categoriasRepository.findById(id).get();
        updateCategoria.setNombrecategoria(categoria.getNombrecategoria());
        categoriasRepository.save(updateCategoria);
        return "Categoría actualizada";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategoria(@PathVariable int id) {
        Categorias deleteCategoria = categoriasRepository.findById(id).get();
        categoriasRepository.delete(deleteCategoria);
        return "Categoría eliminada";
    }
}