// ControllerAgendas.java
package com.jdc.hospital_crud.controller;

import com.jdc.hospital_crud.model.Agendas;
import com.jdc.hospital_crud.repository.AgendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendas")
public class ControllerAgendas {

    @Autowired
    private AgendasRepository agendasRepository;

    @GetMapping("/")
    public String holaMundo() {
        return "Hola mundo desde Agendas";
    }

    @GetMapping("/all")
    public List<Agendas> getAgendas() {
        return agendasRepository.findAll();
    }

    @PostMapping("/save")
    public String saveAgenda(@RequestBody Agendas agenda) {
        agendasRepository.save(agenda);
        return "Agenda guardada";
    }

    @PutMapping("/update/{id}")
    public String updateAgenda(@PathVariable int id, @RequestBody Agendas agenda) {
        Agendas updateAgenda = agendasRepository.findById(id).get();
        updateAgenda.setPostcitas(agenda.getPostcitas());
        updateAgenda.setPaciente(agenda.getPaciente());
        agendasRepository.save(updateAgenda);
        return "Agenda actualizada";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAgenda(@PathVariable int id) {
        Agendas deleteAgenda = agendasRepository.findById(id).get();
        agendasRepository.delete(deleteAgenda);
        return "Agenda eliminada";
    }
}