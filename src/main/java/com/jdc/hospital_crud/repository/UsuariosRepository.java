package com.jdc.hospital_crud.repository;

import com.jdc.hospital_crud.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
}
