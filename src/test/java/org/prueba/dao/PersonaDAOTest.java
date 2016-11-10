package org.prueba.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.prueba.entity.Persona;
import org.prueba.entity.Trabajo;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.logging.Logger;

/**
 * Created by a185120 on 09/11/2016.
 */
public class PersonaDAOTest {

    private static Logger logger = Logger.getLogger(PersonaDAOTest.class
            .getName());
    private static EntityManager entityManager;

    @Before
    public void createContext () {


        entityManager = Persistence.createEntityManagerFactory("testPU").createEntityManager();

        Persona persona = new Persona();
        persona.setIdPersona(1);
        persona.setNombre("Daniel");

        Trabajo trabajo = new Trabajo();
        trabajo.setId("5");

        persona.getTrabajos().add(trabajo);

        entityManager.getTransaction().begin();
        //entityManager.persist(trabajo);
        entityManager.persist(persona);
        entityManager.getTransaction().commit();

    }

    @Test
    public void findTest() {
        Persona persona = new Persona();
        persona.setIdPersona(1);

        entityManager.createQuery("SELECT p FROM Persona p join fetch p.trabajos WHERE p.idPersona = 1");

    }

}