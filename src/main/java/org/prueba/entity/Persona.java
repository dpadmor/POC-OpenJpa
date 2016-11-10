package org.prueba.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a185120 on 09/11/2016.
 */
@Entity
public class Persona {

    @Id
    private Integer idPersona;

    private String nombre;

    @OneToMany(mappedBy = "trabajador", cascade = CascadeType.PERSIST,fetch= FetchType.LAZY)
    private List<Trabajo> trabajos = new ArrayList();

    public Persona() {
    }

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

    public List<Trabajo> getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(List<Trabajo> trabajos) {
        this.trabajos = trabajos;
    }
}
