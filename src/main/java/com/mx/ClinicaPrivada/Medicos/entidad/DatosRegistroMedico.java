package com.mx.ClinicaPrivada.Medicos.entidad;

public record DatosRegistroMedico(

        String nombre,
        
        String apellidopaterno,
        
        String apellidomaterno,
        
        String telefono,

        String cedula,

        String email,

        Especialidad especialidad
        
        

) {
}
