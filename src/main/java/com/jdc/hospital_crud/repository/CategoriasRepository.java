// ArticlesRepository.java
package com.jdc.hospital_crud.repository;

import com.jdc.hospital_crud.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasRepository extends JpaRepository<Categorias, Integer> {
}