package metodos;

import entidad.Medico;

import java.util.List;

public interface Metodos {
    public List<Medico> listamedicos();
    public void guardar(Medico medico);
    public Medico buscarPorID(Medico medico);
    public void actualizar(Medico medico);
    public void borrar(int id);
}
