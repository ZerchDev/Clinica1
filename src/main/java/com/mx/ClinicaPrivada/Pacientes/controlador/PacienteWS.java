package com.mx.ClinicaPrivada.Pacientes.controlador;


import com.mx.ClinicaPrivada.Pacientes.entidad.Paciente;
import com.mx.ClinicaPrivada.Pacientes.entidad.PacienteRepository;
import com.mx.ClinicaPrivada.Pacientes.entidad.PacienteService;
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
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PacienteWS {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteService pacienteService;

    //localhost:8081/api/listapacientes
    @GetMapping("/listapacientes")
    public List<Paciente> listaPacientes() {
        return pacienteRepository.findAll(Sort.by(Sort.Order.asc("id")));

    }

    //localhost:8081/api/guardar
    @PostMapping("/guardar")
    public ResponseEntity<Paciente> crearPaciente(@RequestBody Paciente paciente) {
        String mensaje = "GUARDADO!!";
        Paciente pacienteCreado = pacienteService.crearPaciente(paciente);
        return new ResponseEntity(mensaje, HttpStatus.CREATED);
    }

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
        //SE CREO LA VARIABLE dateTime para truncar los milisegundos
        LocalDateTime dateTime = LocalDateTime.now();
        //truncatedTo(ChronoUnit.SECONDS) es para eliminar los milisegundos
        LocalDateTime truncatedDateTime = dateTime.truncatedTo(ChronoUnit.SECONDS);
        if (paciente.isEstado() == true) {
            paciente.setFechaSalida(null);
        } else {
            paciente.setFechaSalida(truncatedDateTime);//truncatedDateTime se le asigno a FechaSalida ya sin los milisegundos
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
    public ResponseEntity eliminarPacienteBD(@RequestBody Paciente paciente) {
        String mensaje = "ELIMINADO DEFINITIVAMENTE";
        pacienteRepository.delete(paciente);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensaje);

    }
}

