package com.mx.ClinicaPrivada.Medicos.controlador;


import com.mx.ClinicaPrivada.Medicos.entidad.Medico;
import com.mx.ClinicaPrivada.Medicos.entidad.MedicoRepository;
import com.mx.ClinicaPrivada.Pacientes.entidad.Paciente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class MedicoWS {

    @Autowired
    private MedicoRepository medicoRepository;

    //localhost:8081/api/mostrarmedicos
    //@GetMapping("/mostrarmedicos")
    //public List<Medico>mostrarmedicos(){
    //  return imp.listamedicos();
    //}

    /*@GetMapping("/mostrarmedicos")
    public Page<DatosListadoMedico> listadoMedicos(@PageableDefault(size = 2) Pageable paginacion) {
        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
    }*/


    //localhost:8081/api/mostrarmedicosnormal
    @GetMapping("/mostrarmedicosnormal")
    public List<Medico> mostrarmedicosnormal() {
        return medicoRepository.listar();
        //System.out.println("si se manda a llamar elmetodo");
    }

    //localhost:8081/api/guardarmedico
    @PostMapping("/guardarmedico")
    public ResponseEntity guardarmedico(@RequestBody Medico medico) {
        String mensaje = "GUARDADO!!";
        medicoRepository.save(medico);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensaje);
    }

    //localhost:8081/api/eliminarmedico
    @DeleteMapping("/eliminarmedico")
    public ResponseEntity eliminarMedico(@RequestBody Medico medico) {
        String mensaje = "ELIMINADO!!!";
        medicoRepository.delete(medico);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensaje);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarMedico(@PathVariable int id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
        return ResponseEntity.noContent().build();
    }

    //localhost:8081/api/actualizarmedico
    @PutMapping("/actualizarmedico")
    @Transactional
    public ResponseEntity actualizarMedico(@RequestBody Medico medico) {
        medicoRepository.save(medico);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    //localhost:8081/api/buscarnombre
    @GetMapping("/buscarnombre")
    public ResponseEntity<Medico> buscarnombre(@RequestBody Medico medico) {
        String mensaje = null;
        if (medicoRepository.buscarPorNombre(medico.getNombre()) != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(medicoRepository.buscarPorNombre(medico.getNombre()));
        } else {
            mensaje = "EL REGISTRO: '" + medico.getNombre() + "' NO EXISTE! VERIFICAR!";
        }
        return new ResponseEntity(mensaje, HttpStatus.BAD_REQUEST);
    }

    //localhost:8081/api/medicosActivos
    @GetMapping("/medicosActivos")
    public List<Medico> medicosActivos() {
        return  medicoRepository.findByActivoTrue();
    }

    //localhost:8081/api/medicosInactivos
    @GetMapping("/medicosInactivos")
    public List<Medico> medicosInactivos() {
        return  medicoRepository.findByActivoFalse();
    }

    //localhost:8081/api/buscarmedicoporid/{id}
    @GetMapping("buscarmedicoporid/{id}")
    public ResponseEntity<?> buscarmedicoporid(@PathVariable int id) {
        //El Optional se creo para verificar si el ID esta registrado o no existe en Medicos
        Optional<Medico> doctor = medicoRepository.findById(id);

        // Si no se encuentra, devolver un mensaje de error
        if (doctor.isEmpty()) {
            return ResponseEntity.badRequest().body("ID NO ENCONTRADO!");
        }

        // Si se encuentra, devolver los datos del médico
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(doctor.get());
    }
}
