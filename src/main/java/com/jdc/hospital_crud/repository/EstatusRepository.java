package com.jdc.hospital_crud.repository;

import com.jdc.hospital_crud.model.Estatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstatusRepository extends JpaRepository<Estatus, Integer> {
}