package com.mx.ClinicaPrivada.entidad;

public record DatosListadoMedico(String nombre,

                                 String apellidoPaterno,

                                 String apellidoMaterno,

                                 int telefono,

                                 String cedula,

                                 String email,

                                 String especialidad) {
    public DatosListadoMedico (Medico medico){
        this(medico.getNombre(), medico.getApellidoPaterno(), medico.getApellidoMaterno(), medico.getTelefono(), medico.getCedula(), medico.getEmail(), medico.getEspecialidad());
    }
}
