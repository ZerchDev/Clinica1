package com.mx.ClinicaPrivada.entidades.medicos;

public record DatosListadoMedico(
                                 String nombre,

                                 String apellidopaterno,

                                 String apellidomaterno,

                                 String telefono,

                                 String cedula,

                                 String email,

                                 String especialidad,

                                 boolean activo) {

    public DatosListadoMedico (Medico medico){
        this( medico.getNombre(), medico.getApellidopaterno(), medico.getApellidomaterno(),
                medico.getTelefono(), medico.getCedula(), medico.getEmail(),
                medico.getEspecialidad().toString(),medico.isActivo());
    }
}
