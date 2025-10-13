// ControllerCitas.java
package com.jdc.hospital_crud.controller;

import com.jdc.hospital_crud.model.Citas;
import com.jdc.hospital_crud.repository.CitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class ControllerCitas {

    @Autowired
    private CitasRepository citasRepository;

    @GetMapping("/")
    public String holaMundo() {
        return "Hola mundo desde Citas";
    }

    @GetMapping("/all")
    public List<Citas> getCitas() {
        return citasRepository.findAll();
    }

    @PostMapping("/save")
    public String saveCita(@RequestBody Citas cita) {
        citasRepository.save(cita);
        return "Cita guardada";
    }

    @PutMapping("/update/{id}")
    public String updateCita(@PathVariable int id, @RequestBody Citas cita) {
        Citas updateCita = citasRepository.findById(id).get();
        updateCita.setTitulo(cita.getTitulo());
        updateCita.setNota(cita.getNota());
        updateCita.setFecha_cita(cita.getFecha_cita());
        updateCita.setSintomas(cita.getSintomas());
        updateCita.setMedicamentos(cita.getMedicamentos());
        updateCita.setTipocita(cita.getTipocita());
        updateCita.setAntecedentes(cita.isAntecedentes());
        updateCita.setMedico(cita.getMedico());
        updateCita.setPago(cita.getPago());
        updateCita.setEstatus(cita.getEstatus());
        updateCita.setPaciente(cita.getPaciente());
        updateCita.setAgenda(cita.getAgenda());
        citasRepository.save(updateCita);
        return "Cita actualizada";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCita(@PathVariable int id) {
        Citas deleteCita = citasRepository.findById(id).get();
        citasRepository.delete(deleteCita);
        return "Cita eliminada";
    }
}