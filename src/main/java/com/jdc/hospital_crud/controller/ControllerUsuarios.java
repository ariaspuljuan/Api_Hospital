// ControllerUsuarios.java
package com.jdc.hospital_crud.controller;

import com.jdc.hospital_crud.model.Usuarios;
import com.jdc.hospital_crud.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class ControllerUsuarios {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @GetMapping("/")
    public String holaMundo() {
        return "Hola mundo desde Usuarios";
    }

    @GetMapping("/all")
    public List<Usuarios> getUsuarios() {
        return usuariosRepository.findAll();
    }

    @PostMapping("/save")
    public String saveUsuario(@RequestBody Usuarios usuario) {
        usuariosRepository.save(usuario);
        return "Usuario guardado";
    }

    @PutMapping("/update/{id}")
    public String updateUsuario(@PathVariable int id, @RequestBody Usuarios usuario) {
        Usuarios updateUsuario = usuariosRepository.findById(id).get();
        updateUsuario.setUsername(usuario.getUsername());
        updateUsuario.setPassword(usuario.getPassword());
        updateUsuario.setEstado(usuario.isEstado());
        usuariosRepository.save(updateUsuario);
        return "Usuario actualizado";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable int id) {
        Usuarios deleteUsuario = usuariosRepository.findById(id).get();
        usuariosRepository.delete(deleteUsuario);
        return "Usuario eliminado";
    }
}