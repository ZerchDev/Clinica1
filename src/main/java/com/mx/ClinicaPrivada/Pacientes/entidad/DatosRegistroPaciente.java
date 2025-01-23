package com.mx.ClinicaPrivada.Pacientes.entidad;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DatosRegistroPaciente(
        String nombre,

        String apellidoPaterno,

        String apellidoMaterno,

        LocalDate fechaNacimiento,

        Genero genero,

        String telefono,

        String email,

        String direccion,

        LocalDateTime fechaRegistro
) {
}
