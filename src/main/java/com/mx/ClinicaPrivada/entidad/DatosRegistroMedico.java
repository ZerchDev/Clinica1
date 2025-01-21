package com.mx.ClinicaPrivada.entidad;

public record DatosRegistroMedico(

        String nombre,
        
        String apellidopaterno,
        
        String apellidomaterno,
        
        String telefono,

        String cedula,

        String email,

        String especialidad,

        boolean activo
) {
}
