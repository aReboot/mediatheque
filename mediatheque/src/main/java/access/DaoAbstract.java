/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * A generic dao, must be extend to a specific dao
 *
 * @author Adrien
 * @param <E> data base entity
 * @param <K> primary key
 */
public abstract class DaoAbstract<E, K> implements Serializable {

    protected Class<E> entityClass;
    @PersistenceContext
    protected EntityManager em;

    @PostConstruct
    public void init() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperClass.getActualTypeArguments()[0];
    }

    /**
     * @param entity
     * @return persisted entity
     */
    public E save(E entity) {
        em.persist(entity);
        return entity;
    }

    /**
     * @param entity
     * @return merged entity
     */
    public E update(E entity) {
        return em.merge(entity);
    }

    /**
     * @param entity
     */
    public void remove(E entity) {
        em.remove(em.merge(entity));
    }

    /**
     * @param primaryKey
     * @return the entity
     */
    public E findById(K primaryKey) {
        return em.find(entityClass, primaryKey);
    }

    /**
     * @return all the entities
     */
    public List<E> findAll() {
        return em.createNamedQuery(entityClass.getSimpleName() + ".findAll", entityClass).getResultList();
    }

}
