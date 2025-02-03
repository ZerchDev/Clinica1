package com.mx.ClinicaPrivada.Medicos.entidad;

import com.mx.ClinicaPrivada.Pacientes.entidad.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico,Integer> {
    @Query(value = "SELECT * FROM medicos ORDER BY ID ASC", nativeQuery = true)
    List<Medico> listar();

    @Query(value = "SELECT * FROM medicos where nombre = ?", nativeQuery = true)
    Medico buscarPorNombre(@Param("nombre")String nombre);


    List<Medico> findByActivoTrue();

    List<Medico> findByActivoFalse();
}
