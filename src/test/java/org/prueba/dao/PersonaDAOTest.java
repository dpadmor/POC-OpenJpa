package org.prueba.dao;

import org.apache.openjpa.persistence.EntityManagerImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.prueba.entity.Persona;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.sql.DriverManager;
import java.sql.SQLException;
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

            entityManager.getTransaction().begin();
            entityManager.persist(persona);
            entityManager.getTransaction().commit();

    }

    @Test
    public void findTest() {
        Persona persona = new Persona();
        persona.setIdPersona(1);

        Persona personaTemp = entityManager.find(Persona.class, 1);
        Assert.assertNotNull(personaTemp);
    }

}