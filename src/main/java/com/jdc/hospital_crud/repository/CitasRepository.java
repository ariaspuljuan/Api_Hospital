// CommentsRepository.java
package com.jdc.hospital_crud.repository;

import com.jdc.hospital_crud.model.Citas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitasRepository extends JpaRepository<Citas, Integer> {
}