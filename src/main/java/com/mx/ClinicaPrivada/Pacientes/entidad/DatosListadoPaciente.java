package com.mx.ClinicaPrivada.Pacientes.entidad;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DatosListadoPaciente(
        String num_seguro,

        String nombre,

        String apellidoPaterno,

        String apellidoMaterno,

        LocalDate fechaNacimiento,

        String genero,

        String telefono,

        String email,

        String direccion,

        LocalDateTime fechaRegistro,

        String habitacion,

        LocalDateTime fechaSalida,

        boolean estado,

        String observaciones) {
    public DatosListadoPaciente(Paciente paciente) {
        this(paciente.getNum_Seguro(), paciente.getNombre(), paciente.getApellidoPaterno(), paciente.getApellidoMaterno(),
                paciente.getFechaNacimiento(), paciente.getGenero().toString(), paciente.getTelefono(), paciente.getEmail(),
                paciente.getDireccion(), paciente.getFechaRegistro(), paciente.getHabitacion(), paciente.getFechaSalida(),
                paciente.isEstado(), paciente.getObservaciones());
    }
}
