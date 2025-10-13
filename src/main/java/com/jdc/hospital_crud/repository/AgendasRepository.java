// CategoriesRepository.java
package com.jdc.hospital_crud.repository;

import com.jdc.hospital_crud.model.Agendas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendasRepository extends JpaRepository<Agendas, Integer> {
}