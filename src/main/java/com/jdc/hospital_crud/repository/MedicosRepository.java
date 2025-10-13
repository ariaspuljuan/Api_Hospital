// TagsRepository.java
package com.jdc.hospital_crud.repository;
import com.jdc.hospital_crud.model.Medicos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicosRepository extends JpaRepository<Medicos, Integer> {
}