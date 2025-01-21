package com.mx.ClinicaPrivada.controlador;


import com.mx.ClinicaPrivada.entidad.DatosListadoMedico;
import com.mx.ClinicaPrivada.entidad.Medico;
import com.mx.ClinicaPrivada.entidad.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/mostrarmedicos")
    public Page<DatosListadoMedico> listadoMedicos(@PageableDefault(size = 2) Pageable paginacion) {
        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
    }


    //localhost:8081/api/mostrarmedicosnormal
    @GetMapping("/mostrarmedicosnormal")
    public List<?> mostrarmedicosnormal() {
        return medicoRepository.listar();
        //System.out.println("si se manda a llamar elmetodo");
    }

    //localhost:8081/api/guardarmedico
    @PostMapping("/guardarmedico")
    public void guardarmedico(@RequestBody Medico medico) {
        medicoRepository.save(medico);
    }

    //localhost:8081/api/eliminarmedico
    @DeleteMapping("/eliminarmedico")
    public void eliminarMedico(@RequestBody Medico medico){
        medicoRepository.delete(medico);
    }
}
