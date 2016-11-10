package org.prueba.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.prueba.entity.Persona;
import org.prueba.entity.Trabajo;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;
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
        /*org.hsqldb.util.DatabaseManagerSwing.main(new String[] {
                "--url",  "jdbc:hsqldb:mem:testdb", "--noexit"
        });*/

        entityManager = Persistence.createEntityManagerFactory("testPU").createEntityManager();

        Persona persona = new Persona();
        persona.setIdPersona(1);
        persona.setNombre("Daniel");



        for (int i = 0; i < 10; i++) {
            Trabajo trabajo = new Trabajo();
            trabajo.setId(String.valueOf(i));
            trabajo.setTrabajador(persona);

            persona.getTrabajos().add(trabajo);
        }

        entityManager.getTransaction().begin();
        //entityManager.persist(trabajo);
        entityManager.persist(persona);
        entityManager.getTransaction().commit();

    }

    @Test
    public void findTest2() {
        List<Persona> resultList = entityManager.createQuery("SELECT p FROM Persona p").getResultList();
        System.out.println(resultList);
        List<Trabajo> trabajos = resultList.get(0).getTrabajos();
        for (Trabajo trabajo : trabajos) {
            System.out.println("ID " + trabajo.getId());
        }

    }

    @Test
    public void findTest() {
        logger.log(Level.INFO, "PRUEBAAAAAAAAA");

        logger.log(Level.INFO, "Con Fetch");
        Query query = entityManager.createQuery("SELECT p FROM Persona p INNER JOIN FETCH  p.trabajos ");
        List<Persona> resultList = query.getResultList();
        System.out.println(resultList);
        List<Trabajo> trabajos = resultList.get(0).getTrabajos();
        for (Trabajo trabajo : trabajos) {
            System.out.println("ID " + trabajo.getId());
        }
    }

    @Test
    public void findTest4() {
        logger.log(Level.INFO,"SIN Fetch");
        Query query2 = entityManager.createQuery("SELECT p FROM Persona p JOIN  p.trabajos p2");
        List<Persona> resultList2 = query2.getResultList();
        List<Trabajo> trabajos = resultList2.get(0).getTrabajos();
        for (Trabajo trabajo : trabajos) {
            System.out.println("ID " + trabajo.getId());
        }
    }


    @Test
    public void findTest3() {
        logger.log(Level.INFO,"Con Fetch");
        Query query = entityManager.createQuery("SELECT t FROM Trabajo t INNER JOIN FETCH  t.trabajador  WHERE t.id = '3'");
        List resultList = query.getResultList();
        System.out.println(resultList);
    }

}