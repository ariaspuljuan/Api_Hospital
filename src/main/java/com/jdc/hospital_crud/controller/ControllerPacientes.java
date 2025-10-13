// ControllerPacientes.java
package com.jdc.hospital_crud.controller;

import com.jdc.hospital_crud.model.Pacientes;
import com.jdc.hospital_crud.repository.PacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class ControllerPacientes {

    @Autowired
    private PacientesRepository pacientesRepository;

    @GetMapping("/")
    public String holaMundo() {
        return "Hola mundo desde Pacientes";
    }

    @GetMapping("/all")
    public List<Pacientes> getPacientes() {
        return pacientesRepository.findAll();
    }

    @PostMapping("/save")
    public String savePaciente(@RequestBody Pacientes paciente) {
        pacientesRepository.save(paciente);
        return "Paciente guardado";
    }

    @PutMapping("/update/{id}")
    public String updatePaciente(@PathVariable int id, @RequestBody Pacientes paciente) {
        Pacientes updatePaciente = pacientesRepository.findById(id).get();
        updatePaciente.setNombres(paciente.getNombres());
        updatePaciente.setPrimerApellido(paciente.getPrimerApellido());
        updatePaciente.setSegundoApellido(paciente.getSegundoApellido());
        updatePaciente.setDocumento(paciente.getDocumento());
        updatePaciente.setFechaNacimiento(paciente.getFechaNacimiento());
        updatePaciente.setMedicamentos(paciente.getMedicamentos());
        updatePaciente.setAlergias(paciente.getAlergias());
        updatePaciente.setUsuario(paciente.getUsuario());
        pacientesRepository.save(updatePaciente);
        return "Paciente actualizado";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePaciente(@PathVariable int id) {
        Pacientes deletePaciente = pacientesRepository.findById(id).get();
        pacientesRepository.delete(deletePaciente);
        return "Paciente eliminado";
    }
}