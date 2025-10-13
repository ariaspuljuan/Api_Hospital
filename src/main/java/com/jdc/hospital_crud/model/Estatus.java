// Estatus.java
package com.jdc.hospital_crud.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "estatus")
public class Estatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idestatus;

    @Column(nullable = false, length = 200)
    private String nombreEstatus;

    // Relación con Citas
    @OneToMany(mappedBy = "estatus", cascade = CascadeType.ALL)
    private List<Citas> citas;

    // Getters y Setters
    public int getIdestatus() {
        return idestatus;
    }

    public void setIdestatus(int idestatus) {
        this.idestatus = idestatus;
    }

    public String getNombreEstatus() {
        return nombreEstatus;
    }

    public void setNombreEstatus(String nombreEstatus) {
        this.nombreEstatus = nombreEstatus;
    }

    public List<Citas> getCitas() {
        return citas;
    }

    public void setCitas(List<Citas> citas) {
        this.citas = citas;
    }
}