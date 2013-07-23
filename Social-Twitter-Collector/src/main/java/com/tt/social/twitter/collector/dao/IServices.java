package com.tt.social.twitter.collector.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.Metamodel;


public interface IServices<DO> {

	public <T> void create(T entity);

	public <T> void delete(T entity) throws NoResultException;

	public <T> DO save(DO entity);
	
	/*public <KEY, T> T findById(final Class<T> type, final KEY id );
	
	public <KEY, T> T deleteById(final Class<T> type, final KEY id) throws NoResultException;*/
	
	public <T> TypedQuery<T> createTypedQuery(final Class<T> type, final String queryStr, final Object... params);
	
	public Query createQuery(final String queryStr, final Object... params);
	
	public Query createNamedQuery(final String name, final Object... params);
	
	public int execNativeQuery(final String queryStr, final Object... params);
	
	public Query createNativeQuery(final String queryStr, final Object... params);
	
	public Query createNativeQueryWithObjectMapper(final String queryStr, String objectMapper,final Object... params);
	
	public <T> TypedQuery<T> createNamedAndTypedQuery(final Class<T> type, final String name, final Object... params);
	
	public Query createQuery(CriteriaQuery<Object> criteria);
	
	public CriteriaQuery<Object> createCriteriaQuery();
	
	public Metamodel getMetaModel();
	
	public CriteriaBuilder createCriteriaBuilder();

}
