package servicios;

import dao.MedicoDao;
import entidad.Medico;
import metodos.Metodos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class implementacion implements Metodos {
    @Autowired
    MedicoDao dao;

    @Override
    public List<Medico> listamedicos() {
        return dao.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    @Override
    public void guardar(Medico medico) {
        dao.save(medico);
    }

    @Override
    public Medico buscarPorID(Medico medico) {
        return null;
    }

    @Override
    public void actualizar(Medico medico) {

    }

    @Override
    public void borrar(int id) {

    }
}
