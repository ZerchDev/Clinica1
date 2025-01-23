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

    @Column(name = "apellidomaterno", insertable=false, updatable=false)
    private String apellidoPaterno;
    @Column(name = "apellidomaterno", insertable=false, updatable=false)
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
    }
}
