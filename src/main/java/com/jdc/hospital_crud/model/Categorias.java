// Categorias.java
package com.jdc.hospital_crud.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcategoria;

    @Column(nullable = false, length = 50)
    private String nombrecategoria;

    // Relación con Medicos
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Medicos> medicos;

    // Getters y Setters
    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombrecategoria() {
        return nombrecategoria;
    }

    public void setNombrecategoria(String nombrecategoria) {
        this.nombrecategoria = nombrecategoria;
    }

    public List<Medicos> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medicos> medicos) {
        this.medicos = medicos;
    }
}