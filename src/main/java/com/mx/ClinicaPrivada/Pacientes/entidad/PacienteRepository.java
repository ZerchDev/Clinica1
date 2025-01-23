package com.mx.ClinicaPrivada.Pacientes.entidad;

import com.mx.ClinicaPrivada.Medicos.entidad.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
   /* @Query(value = "SELECT * FROM pacientes ORDER BY id ASC",nativeQuery = true)List<Paciente> listarPaciente();*/
   // Buscar pacientes activos y devolver una página con resultados
     Page<Paciente> findByEstadoTrue(Pageable pageable);

    // Buscar pacientes cuyo estado es TRUE (activos)
    List<Paciente> findByEstadoTrue();


    List<Paciente> findByEstadoFalse();

}
