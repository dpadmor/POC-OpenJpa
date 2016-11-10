package org.prueba.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by a185120 on 10/11/2016.
 */
@Entity
public class Trabajo {


    @Id
    private String id;

    private String nombreTrabajo;

    @ManyToOne
    private Persona trabajador;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreTrabajo() {
        return nombreTrabajo;
    }

    public void setNombreTrabajo(String nombre) {
        this.nombreTrabajo = nombre;
    }

    public Persona getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Persona trabajador) {
        this.trabajador = trabajador;
    }
}
