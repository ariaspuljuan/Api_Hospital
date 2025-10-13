// Pagos.java
package com.jdc.hospital_crud.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "pagos")
public class Pagos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpago;

    @Column(nullable = false, length = 100)
    private String tipoPago;

    // Relación con Citas
    @OneToMany(mappedBy = "pago", cascade = CascadeType.ALL)
    private List<Citas> citas;

    // Getters y Setters
    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public List<Citas> getCitas() {
        return citas;
    }

    public void setCitas(List<Citas> citas) {
        this.citas = citas;
    }
}