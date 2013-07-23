package com.tt.social.twitter.collector.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.Metamodel;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;

import com.tt.social.twitter.collector.dao.IServices;
import com.tt.social.twitter.collector.domains.XborderSocialData;


@Configurable
public class BaseDaoImpl<DO extends XborderSocialData> implements IServices<DO>{
	
	@PersistenceContext(unitName="entityManagerFactory_social_data")
	public EntityManager em;
	
	private CriteriaBuilder builder;
	
    private CriteriaQuery<Object> criteria;
	
	public BaseDaoImpl(){
	}
	
	/**
	 * Create a typed select query 
	 * @param type
	 * @param queryStr
	 * @param params
	 * @return
	 */
	public <T> TypedQuery<T> createTypedQuery(final Class<T> type, final String queryStr, final Object... params)
	{
		TypedQuery<T> query = em.createQuery(queryStr, type);
		int i = 1;
		for (Object p : params)
		{
			query.setParameter(i++, p);
		}
		return query;
	}
	
	
	/**
	 * Create a select query without the return type known
	 * @param queryStr
	 * @param params
	 * @return
	 */
	public Query createQuery(final String queryStr, final Object... params)
	{
		Query query = em.createQuery(queryStr);
		int i = 1;
		for (Object p : params)
		{
			query.setParameter(i++, p);
		}
		return query;
	}
	
	
	/**
	 *  create typed query from named statement 
	 * @param name
	 * @param params
	 * @return
	 */
	public Query createNamedQuery(final String name, final Object... params)
	{
		Query query = em.createNamedQuery(name);
		int i = 1;
		for (Object p : params)
		{
			query.setParameter(i++, p);
		}
		return query;
	}
	
	/**
	 * Exec a native query (for update, delete, modify schema etc)
	 * @param queryStr
	 * @param params
	 * @return
	 */
	@Transactional("social-data")
	public int execNativeQuery(final String queryStr, final Object... params)
	{
		Query query = em.createNativeQuery(queryStr);
		int i = 1;
		for (Object p : params)
		{
			query.setParameter(i++, p);
		}
		return query.executeUpdate();
	}
	
//	@Transactional(""social-data"")
	public Query createNativeQuery(final String queryStr, final Object... params) {
		Query query = em.createNativeQuery(queryStr);
		int i = 1;
		for (Object p : params)
		{
			query.setParameter(i++, p);
		}
		return query;
	}
	
	
	public CriteriaBuilder createCriteriaBuilder(){
		this.builder = em.getCriteriaBuilder();
		return builder;
	}
	
	
	/**
	 *  create typed select query from named statement 
	 * @param type
	 * @param name
	 * @param params
	 * @return
	 */
	public <T> TypedQuery<T> createNamedAndTypedQuery(final Class<T> type, final String name, final Object... params)
	{
		TypedQuery<T> query = em.createNamedQuery(name, type);
		int i = 1;
		for (Object p : params)
		{
			query.setParameter(i++, p);
		}
		return query;
	}
		
	/**
	 * Creates a new entity and persist to DBR
	 * @param entity
	 */
	@Transactional("social-data")
	public <T> void create(final T entity)
	{
		em.persist(entity);
	}
	
	
	/**
	 * Deletes a entity
	 * @param entity
	 * @throws NoResultException
	 */
	@Transactional("social-data")
	public <T> void delete(final T entity) throws NoResultException
	{
		if(!em.contains(entity)) {
			em.remove(em.merge(entity));
		} else {
			em.remove(entity);
		}
	}
	
	
	/**
	 * Deletes a entity by primary key
	 * @param type
	 * @param id
	 * @return
	 * @throws NoResultException
	 */
	@Transactional("social-data")
	public <T, KEY> T deleteById(final Class<T> type, final KEY id) throws NoResultException
	{
		T object = findById(type, id);
		delete(object);
		return object;
	}
	
	
	/**
	 * Save a modified entity, persist the change to db 
	 * @param entity
	 * @return
	 */
	@Transactional("social-data")
	public <T> DO save(final DO entity)
	{
		return em.merge(entity);
	}
	
	
	/**
	 * Find and return  a entity by id
	 * @param type
	 * @param id
	 * @return
	 * @throws NoResultException
	 */
	@Transactional("social-data")
	public <T,KEY > T findById(final Class<T> type, final KEY id) throws NoResultException
	{
		if (type == null)
		{
			throw new IllegalArgumentException("Null has no type. You must pass an Object");
		}
		T result =  em.find(type, id);
		if (result == null)
		{
			throw new NoResultException("No object of type: " + type + " with ID: " + id);
		}
		return result;
	}
	
	public Query createQuery(CriteriaQuery<Object> criteria) {
		return em.createQuery(criteria);
	}
	
	public CriteriaQuery<Object> createCriteriaQuery() {
		return this.builder.createQuery();
	}
	
	public Metamodel getMetaModel(){
		return em.getMetamodel();
	}

	public Query createNativeQueryWithObjectMapper(String queryStr,
			String objectMapper, final Object... params) {
		Query query = em.createNativeQuery(queryStr, objectMapper);
		int i = 1;
		for (Object p : params)
		{
			query.setParameter(i++, p);
		}
		return query;
	}

	public <T> Object getIdentifier(final T entity)
	{
		return em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity);
	}
}
