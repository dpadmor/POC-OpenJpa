package org.prueba.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by a185120 on 09/11/2016.
 */
@Entity
public class Persona {

    @Id
    private Integer idPersona;

    private String nombre;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
