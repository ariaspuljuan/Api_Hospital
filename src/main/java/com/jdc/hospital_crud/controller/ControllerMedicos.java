// ControllerMedicos.java
package com.jdc.hospital_crud.controller;

import com.jdc.hospital_crud.model.Medicos;
import com.jdc.hospital_crud.repository.MedicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class ControllerMedicos {

    @Autowired
    private MedicosRepository medicosRepository;

    @GetMapping("/")
    public String holaMundo() {
        return "Hola mundo desde Medicos";
    }

    @GetMapping("/all")
    public List<Medicos> getMedicos() {
        return medicosRepository.findAll();
    }

    @PostMapping("/save")
    public String saveMedico(@RequestBody Medicos medico) {
        medicosRepository.save(medico);
        return "Médico guardado";
    }

    @PutMapping("/update/{id}")
    public String updateMedico(@PathVariable int id, @RequestBody Medicos medico) {
        Medicos updateMedico = medicosRepository.findById(id).get();
        updateMedico.setNombres(medico.getNombres());
        updateMedico.setPrimerApellido(medico.getPrimerApellido());
        updateMedico.setSegundoApellido(medico.getSegundoApellido());
        updateMedico.setGenero(medico.getGenero());
        updateMedico.setEmail(medico.getEmail());
        updateMedico.setTelefono(medico.getTelefono());
        updateMedico.setCategoria(medico.getCategoria());
        medicosRepository.save(updateMedico);
        return "Médico actualizado";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMedico(@PathVariable int id) {
        Medicos deleteMedico = medicosRepository.findById(id).get();
        medicosRepository.delete(deleteMedico);
        return "Médico eliminado";
    }
}