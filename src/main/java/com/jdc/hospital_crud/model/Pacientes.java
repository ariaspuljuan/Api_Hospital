// Pacientes.java
package com.jdc.hospital_crud.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pacientes")
public class Pacientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpaciente;

    @Column(nullable = false, length = 50)
    private String nombres;

    @Column(nullable = false, length = 15)
    private String primerApellido;

    @Column(nullable = false, length = 15)
    private String segundoApellido;

    @Column(nullable = false, length = 10)
    private String documento;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Column(length = 100)
    private String medicamentos;

    @Column(length = 50)
    private String alergias;

    // Relación con Usuario
    @ManyToOne
    @JoinColumn(name = "idusuario", nullable = false)
    private Usuarios usuario;

    // Relación con Agendas
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Agendas> agendas;

    // Relación con Citas
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Citas> citas;

    // Getters y Setters
    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public List<Agendas> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<Agendas> agendas) {
        this.agendas = agendas;
    }

    public List<Citas> getCitas() {
        return citas;
    }

    public void setCitas(List<Citas> citas) {
        this.citas = citas;
    }
}