package com.mx.ClinicaPrivada.Pacientes.controlador;

import com.mx.ClinicaPrivada.Pacientes.entidad.Paciente;
import com.mx.ClinicaPrivada.Pacientes.entidad.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PacienteWS {
    @Autowired
    PacienteRepository pacienteRepository;

    //localhost:8081/api/listapacientes
    @GetMapping("/listapacientes")
    public List<?> listaPacientes(){
      return pacienteRepository.findAll(Sort.by(Sort.Order.asc("id")));

    }

    //localhost:8081/api/guardar
    @PostMapping("/guardar")
    public ResponseEntity<?> guardarPaciente(@RequestBody Paciente paciente){
        String mensaje = "GUARDADO!";
        pacienteRepository.save(paciente);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensaje);
    }

    //localhost:8081/api/daralta
    @PostMapping("/daralta")
    public ResponseEntity<?> altaPaciente(@RequestBody Paciente paciente){
        String mensaje = " ";
        pacienteRepository.save(paciente);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensaje);
    }
}
