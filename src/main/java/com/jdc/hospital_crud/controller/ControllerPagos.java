// ControllerPagos.java
package com.jdc.hospital_crud.controller;

import com.jdc.hospital_crud.model.Pagos;
import com.jdc.hospital_crud.repository.PagosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class ControllerPagos {

    @Autowired
    private PagosRepository pagosRepository;

    @GetMapping("/")
    public String holaMundo() {
        return "Hola mundo desde Pagos";
    }

    @GetMapping("/all")
    public List<Pagos> getPagos() {
        return pagosRepository.findAll();
    }

    @PostMapping("/save")
    public String savePago(@RequestBody Pagos pago) {
        pagosRepository.save(pago);
        return "Pago guardado";
    }

    @PutMapping("/update/{id}")
    public String updatePago(@PathVariable int id, @RequestBody Pagos pago) {
        Pagos updatePago = pagosRepository.findById(id).get();
        updatePago.setTipoPago(pago.getTipoPago());
        pagosRepository.save(updatePago);
        return "Pago actualizado";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePago(@PathVariable int id) {
        Pagos deletePago = pagosRepository.findById(id).get();
        pagosRepository.delete(deletePago);
        return "Pago eliminado";
    }
}