package controlador;

import entidad.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import servicios.implementacion;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicoWS {
    @Autowired
    implementacion imp;

    //localhost:8081/api/mostrarmedicos
    @GetMapping("/mostrarmedicos")
    public List<Medico>mostrarmedicos(){
        return imp.listamedicos();
    }


}
