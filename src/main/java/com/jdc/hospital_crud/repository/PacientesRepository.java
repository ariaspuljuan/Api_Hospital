// UsersRepository.java
package com.jdc.hospital_crud.repository;

import com.jdc.hospital_crud.model.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientesRepository extends JpaRepository<Pacientes, Integer> {
}

