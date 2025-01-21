package com.mx.ClinicaPrivada.entidad;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidopaterno")
    private String apellidopaterno;
    @Column(name = "apellidomaterno")
    private String apellidomaterno;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "cedula")
    private String cedula;
    @Column(name = "email")
    private String email;
    @Column(name = "especialidad")
    private String especialidad;

    private boolean activo;

    public Medico (DatosRegistroMedico datosRegistroMedico) {
        this.nombre=datosRegistroMedico.nombre();
        this.apellidopaterno=datosRegistroMedico.apellidopaterno();
        this.apellidomaterno=datosRegistroMedico.apellidomaterno();
        this.telefono = datosRegistroMedico.telefono();
        this.cedula=datosRegistroMedico.cedula();
        this.email=datosRegistroMedico.email();
        this.especialidad=datosRegistroMedico.especialidad();
        this.activo=true;
    }
    }