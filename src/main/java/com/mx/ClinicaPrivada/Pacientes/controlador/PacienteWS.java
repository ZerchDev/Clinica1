package com.mx.ClinicaPrivada.Pacientes.controlador;

import com.mx.ClinicaPrivada.Pacientes.entidad.Paciente;
import com.mx.ClinicaPrivada.Pacientes.entidad.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PacienteWS {
    @Autowired
    PacienteRepository pacienteRepository;

    //localhost:8081/api/listapacientes
    @GetMapping("/listapacientes")
    public List<Paciente> listaPacientes() {
        return pacienteRepository.findAll(Sort.by(Sort.Order.asc("id")));

    }

    //localhost:8081/api/guardar
    @PostMapping("/guardarPaciente")
    public ResponseEntity guardarPaciente(@RequestBody Paciente paciente) {
        String mensaje = "GUARDADO!";
        pacienteRepository.save(paciente);
        return ResponseEntity.status(HttpStatus.OK).body(mensaje);
    }

    //localhost:8081/api/daralta
    @PutMapping("/daralta")
    public ResponseEntity altaPaciente(@RequestBody Paciente paciente) {
        String mensaje = " ";
        if (paciente.isEstado() == true) {
            paciente.setFechaSalida(null);
        } else {
            paciente.setFechaSalida(LocalDateTime.now());
        }
        pacienteRepository.save(paciente);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensaje);
    }

    //localhost:8081/api/pacientesinternados
    @GetMapping("/pacientesinternados")
    public List<Paciente> pacientesPagina() {
        return pacienteRepository.findByEstadoTrue(); // Página 0, 10 resultados
    }

    //localhost:8081/api/pacientesConAltaMedica
    @GetMapping("/pacientesConAltaMedica")
    public List<Paciente> pacientesConAltaMedica() {
        return pacienteRepository.findByEstadoFalse(); // Página 0, 10 resultados
    }

    //localhost:8081/api/eliminarPaciente
    @DeleteMapping("/eliminarPaciente")
    @Transactional
    public ResponseEntity eliminarPacienteBD(@RequestBody Paciente paciente){
    String mensaje="ELIMINADO DEFINITIVAMENTE";
    pacienteRepository.delete(paciente);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensaje);

    }
}
