// Usuarios.java
package com.jdc.hospital_crud.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idusuario;

    @Column(nullable = false, unique = true, length = 10)
    private String username;

    @Column(nullable = false, length = 10)
    private String password;

    @Column(nullable = false)
    private boolean estado;

    // Relación con Pacientes
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Pacientes> pacientes;

    // Getters y Setters
    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Pacientes> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Pacientes> pacientes) {
        this.pacientes = pacientes;
    }
}