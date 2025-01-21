package com.mx.ClinicaPrivada.entidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico,Integer> {
    @Query(value = "SELECT * FROM medicos", nativeQuery = true)
    List<Medico> listar();
}
