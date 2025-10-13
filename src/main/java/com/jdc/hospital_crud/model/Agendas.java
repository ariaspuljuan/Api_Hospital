// Agendas.java
package com.jdc.hospital_crud.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "agendas")
public class Agendas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcitas;

    @Column(nullable = false)
    private int postcitas;

    // Relación con Paciente
    @ManyToOne
    @JoinColumn(name = "idpaciente", nullable = false)
    private Pacientes paciente;

    // Relación con Citas
    @OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL)
    private List<Citas> citas;

    // Getters y Setters
    public int getIdcitas() {
        return idcitas;
    }

    public void setIdcitas(int idcitas) {
        this.idcitas = idcitas;
    }

    public int getPostcitas() {
        return postcitas;
    }

    public void setPostcitas(int postcitas) {
        this.postcitas = postcitas;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public List<Citas> getCitas() {
        return citas;
    }

    public void setCitas(List<Citas> citas) {
        this.citas = citas;
    }
}