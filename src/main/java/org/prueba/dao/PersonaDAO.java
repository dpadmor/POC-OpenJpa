package org.prueba.dao;

import javax.persistence.EntityManager;

/**
 * Created by a185120 on 09/11/2016.
 */
public class PersonaDAO {

    private EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


}
