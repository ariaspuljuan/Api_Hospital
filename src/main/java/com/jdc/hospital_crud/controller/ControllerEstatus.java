// ControllerEstatus.java
package com.jdc.hospital_crud.controller;

import com.jdc.hospital_crud.model.Estatus;
import com.jdc.hospital_crud.repository.EstatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estatus")
public class ControllerEstatus {

    @Autowired
    private EstatusRepository estatusRepository;

    @GetMapping("/")
    public String holaMundo() {
        return "Hola mundo desde Estatus";
    }

    @GetMapping("/all")
    public List<Estatus> getEstatus() {
        return estatusRepository.findAll();
    }

    @PostMapping("/save")
    public String saveEstatus(@RequestBody Estatus estatus) {
        estatusRepository.save(estatus);
        return "Estatus guardado";
    }

    @PutMapping("/update/{id}")
    public String updateEstatus(@PathVariable int id, @RequestBody Estatus estatus) {
        Estatus updateEstatus = estatusRepository.findById(id).get();
        updateEstatus.setNombreEstatus(estatus.getNombreEstatus());
        estatusRepository.save(updateEstatus);
        return "Estatus actualizado";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEstatus(@PathVariable int id) {
        Estatus deleteEstatus = estatusRepository.findById(id).get();
        estatusRepository.delete(deleteEstatus);
        return "Estatus eliminado";
    }
}