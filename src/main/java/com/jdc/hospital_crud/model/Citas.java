// Citas.java
package com.jdc.hospital_crud.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "citas")
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcita;

    @Column(nullable = false, length = 50)
    private String titulo;

    @Column(nullable = false, length = 50)
    private String nota;

    @Column(nullable = false)
    private LocalDate fecha_cita;

    @Column(nullable = false, length = 100)
    private String sintomas;

    @Column(nullable = false, length = 100)
    private String medicamentos;

    @Column(nullable = false)
    private int tipocita;

    @Column(nullable = false)
    private boolean antecedentes;

    // Relación con Medico
    @ManyToOne
    @JoinColumn(name = "idmedico", nullable = false)
    private Medicos medico;

    // Relación con Pago
    @ManyToOne
    @JoinColumn(name = "idpago", nullable = false)
    private Pagos pago;

    // Relación con Estatus
    @ManyToOne
    @JoinColumn(name = "idestatus", nullable = false)
    private Estatus estatus;

    // Relación con Paciente
    @ManyToOne
    @JoinColumn(name = "idpaciente", nullable = false)
    private Pacientes paciente;

    // Relación con Agenda
    @ManyToOne
    @JoinColumn(name = "idcitas", nullable = false)
    private Agendas agenda;

    // Getters y Setters
    public int getIdcita() {
        return idcita;
    }

    public void setIdcita(int idcita) {
        this.idcita = idcita;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public LocalDate getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(LocalDate fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public int getTipocita() {
        return tipocita;
    }

    public void setTipocita(int tipocita) {
        this.tipocita = tipocita;
    }

    public boolean isAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(boolean antecedentes) {
        this.antecedentes = antecedentes;
    }

    public Medicos getMedico() {
        return medico;
    }

    public void setMedico(Medicos medico) {
        this.medico = medico;
    }

    public Pagos getPago() {
        return pago;
    }

    public void setPago(Pagos pago) {
        this.pago = pago;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public Agendas getAgenda() {
        return agenda;
    }

    public void setAgenda(Agendas agenda) {
        this.agenda = agenda;
    }
}