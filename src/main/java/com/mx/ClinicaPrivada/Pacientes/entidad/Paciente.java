package com.mx.ClinicaPrivada.Pacientes.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    /*CREATE TABLE pacientes (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellidoPaterno VARCHAR(100) NOT NULL,
    apellidoMaterno VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    genero VARCHAR(20) NOT NULL,
    telefono VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    direccion VARCHAR(100),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidopaterno")
    private String apellidoPaterno;
    @Column(name = "apellidomaterno")
    private String apellidoMaterno;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    private Genero genero;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;
    @Column(name = "direccion")
    private String direccion;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
    @Column(name = "habitacion")
    private String habitacion;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "fechasalida")
    private LocalDateTime fechaSalida;
    //@Column(name = "activo")
    private boolean activo;
    @Column(name = "observaciones")
    private String observaciones;

    @PrePersist
    public void registro() {
        this.fechaRegistro = LocalDateTime.now();  // Asigna la fecha y hora actual
    }

    /*@PrePersist
    public void alta() {
        this.fechaSalida = LocalDateTime.now();  // Asigna la fecha y hora actual
    }*/

    public Paciente(DatosRegistroPaciente datosRegistroPaciente) {
        this.nombre = datosRegistroPaciente.nombre();
        this.apellidoPaterno = datosRegistroPaciente.apellidoPaterno();
        this.apellidoMaterno = datosRegistroPaciente.apellidoMaterno();
        this.fechaNacimiento = datosRegistroPaciente.fechaNacimiento();
        this.genero = datosRegistroPaciente.genero();
        this.telefono = datosRegistroPaciente.telefono();
        this.email = datosRegistroPaciente.email();
        this.direccion= datosRegistroPaciente.direccion();
        this.fechaRegistro = datosRegistroPaciente.fechaRegistro();
        this.habitacion = datosRegistroPaciente.habitacion();
        this.fechaSalida = datosRegistroPaciente.fechaSalida();
        this.activo = true;
        this.observaciones = datosRegistroPaciente.observaciones();
    }

    public void altaPaciente(){
        this.activo = false;
    }

}
