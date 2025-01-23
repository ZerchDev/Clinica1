package com.mx.ClinicaPrivada.Pacientes.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;

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

        LocalDateTime fechaRegistro,

        String habitacion,

        LocalDateTime fechaSalida,

        //boolean activo,

        String observaciones
) {
}
